package com.swigder.nlp.eliza.personality.teenager.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = {"com.swigder.nlp.eliza.personality.teenager.transformer"})
@Profile("teenager")
public class TeenagerConfiguration {

}
