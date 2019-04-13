package com.joselara.crmcustomers.configuration;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.context.annotation.Configuration;

import java.security.Security;

@Configuration
public class SecurityConfiguration {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }
}
