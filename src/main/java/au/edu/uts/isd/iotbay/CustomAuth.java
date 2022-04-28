package au.edu.uts.isd.iotbay;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;

import javax.naming.AuthenticationException;

public class CustomAuth {}

/*
public class CustomAuth implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws Exception {
        final String username = authentication.getPrincipal() == null ? "N/A" : authentication.getName();
        if (username.isEmpty())
            throw new BadCredentialsException("invalid login details");
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
 */
