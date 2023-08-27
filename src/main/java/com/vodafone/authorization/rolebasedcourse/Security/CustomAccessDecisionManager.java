package com.vodafone.authorization.rolebasedcourse.Security;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class CustomAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if (configAttributes == null) {
            return; // No specific access requirements, access is allowed
        }
        for(ConfigAttribute configAttribute : configAttributes){
            String requiredAttribute = configAttribute.getAttribute();
            if(requiredAttribute == null)
                continue;
            for(GrantedAuthority grantedAuthority: authentication.getAuthorities())
                if(requiredAttribute.equals(grantedAuthority.getAuthority()))
                    return;
        }

        throw new AccessDeniedException("Access is denied");
    }
    @Override
    public boolean supports(ConfigAttribute attribute) {
        // Implement as needed
        return true;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        // Implement as needed
        return true;
    }
}

