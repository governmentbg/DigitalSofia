<#import "template.ftl" as layout>
<@layout.registrationLayout; section>
    <#if section = "header">
        <div id="custom-info-icon">i</div>
    <#elseif section = "form">
        <script>window.onload = function() {document.forms[0].submit()};</script>
        <div class="saml-post-form-message">
            <p class="saml-post-form-message-text">${msg("saml.post-form.title")}</p>
            <p class="saml-post-form-message-text">${msg("saml.post-form.message")}</p>
        </div>
        <form name="saml-post-binding" method="post" action="${samlPost.url}">
            <#if samlPost.SAMLRequest??>
                <input type="hidden" name="SAMLRequest" value="${samlPost.SAMLRequest}"/>
            </#if>
            <#if samlPost.SAMLResponse??>
                <input type="hidden" name="SAMLResponse" value="${samlPost.SAMLResponse}"/>
            </#if>
            <#if samlPost.relayState??>
                <input type="hidden" name="RelayState" value="${samlPost.relayState}"/>
            </#if>

            <noscript>
                <p>${msg("saml.post-form.js-disabled")}</p>
                <input type="submit" value="${msg("doContinue")}"/>
            </noscript>
        </form>
    </#if>
</@layout.registrationLayout>