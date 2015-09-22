package com.swigder.nlp.eliza.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Default StreamConfiguration points to System.out and System.in.  Can be overwritten for testing and other purposes.
 */
@Configuration
public class SystemStreamConfiguration {
    @Bean
    public InputStream inputStream() {
        return System.in;
    }

    @Bean
    public PrintStream printStream() {
        return System.out;
    }
}
