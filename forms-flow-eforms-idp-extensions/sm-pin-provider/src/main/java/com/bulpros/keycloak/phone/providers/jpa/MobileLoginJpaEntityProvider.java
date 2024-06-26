package com.bulpros.keycloak.phone.providers.jpa;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;

import java.util.Collections;
import java.util.List;

public class MobileLoginJpaEntityProvider implements JpaEntityProvider {
    @Override
    public List<Class<?>> getEntities() {
        return Collections.singletonList(MobileLogin.class);
    }

    @Override
    public String getChangelogLocation() {
        return "META-INF/changelog/mobile-login-changelog.xml";
    }

    @Override
    public void close() {
    }

    @Override
    public String getFactoryId() {
        return "mobileLoginEntityProvider";
    }
}
