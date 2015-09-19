package com.swigder.nlp.eliza.personality.teenager.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration to add a sullen teenager personality to the responses.
 * To use, pass -Dspring.profiles.active=teenager as a command line argument.
 */
@Configuration
@ComponentScan(basePackages = {"com.swigder.nlp.eliza.personality.teenager.transformer", "com.swigder.nlp.eliza.personality.teenager.responder"})
@Profile("teenager")
public class TeenagerConfiguration {

}
