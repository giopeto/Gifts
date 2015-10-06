package com.gifts.security.config;

import org.springframework.security.web.context.*;
import org.springframework.stereotype.Component;
@Component
public class SecurityWebApplicationInitializer
      extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}