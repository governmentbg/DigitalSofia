package com.bulpros.keycloak.phone.authentication.authenticators.directgrant;

import com.bulpros.keycloak.phone.providers.constants.TokenCodeType;
import com.bulpros.keycloak.phone.providers.spi.PinVerificationCodeProvider;
import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

import java.util.Optional;

public class AuthenticationCodeAuthenticator extends BaseDirectGrantAuthenticator {

    private static final Logger logger = Logger.getLogger(AuthenticationCodeAuthenticator.class);

    public AuthenticationCodeAuthenticator(KeycloakSession session) {
        if (session.getContext().getRealm() == null) {
            throw new IllegalStateException("The service cannot accept a session without a realm in its context.");
        }
    }

    @Override
    public boolean requiresUser() {
        return true;
    }

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
    }

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        Optional.ofNullable(getPinNumber(context)).ifPresentOrElse(number -> validateVerificationCode(context,number),
            ()-> invalidCredentials(context,context.getUser()));
    }



    private void validateVerificationCode(AuthenticationFlowContext context, String phoneNumber) {

        Optional.ofNullable(getAuthenticationCode(context)).ifPresentOrElse(code -> {
            try {
                context.getSession().getProvider(PinVerificationCodeProvider.class).validateCode(context.getUser(), phoneNumber, code, TokenCodeType.AUTH);
                context.success();
            } catch (Exception e) {
                logger.info("Grant authenticator valid code failure",e);
                invalidCredentials(context,context.getUser());
            }
        },() -> invalidCredentials(context,context.getUser()));
    }

}
