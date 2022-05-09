package au.edu.uts.isd.iotbay;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

public class CustomAuth {}
/*
@Component
public class CustomAuth implements AuthenticationProvider {
    @Autowired
    UserManager userManager;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        val username = authentication.getName();
        val password = authentication.getCredentials();

        try {

        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}

 */
