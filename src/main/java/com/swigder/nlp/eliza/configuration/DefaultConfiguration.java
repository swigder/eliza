package com.swigder.nlp.eliza.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.swigder.nlp.eliza.prompter",
        "com.swigder.nlp.eliza.transformer.input",
        "com.swigder.nlp.eliza.transformer.output",
        "com.swigder.nlp.eliza.responder"})
public class DefaultConfiguration {

}
