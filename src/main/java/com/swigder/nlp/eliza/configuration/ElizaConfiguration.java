package com.swigder.nlp.eliza.configuration;

import com.swigder.nlp.eliza.Eliza;
import com.swigder.nlp.eliza.InputHandler;
import com.swigder.nlp.eliza.prompter.Prompter;
import com.swigder.nlp.eliza.response.ResponseGenerator;
import com.swigder.nlp.eliza.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Spring configuration for Eliza which uses all available response generators.
 */
@ComponentScan(basePackages = {"com.swigder.nlp.eliza.response.impl", "com.swigder.nlp.eliza.transformer.input", "com.swigder.nlp.eliza.prompter.impl"})
public class ElizaConfiguration {

    @Autowired private Prompter initialPrompter;
    @Autowired private List<Transformer> inputTransformers;
    @Autowired private List<ResponseGenerator> responseGenerators;

    @Bean
    public InputHandler inputHandler(List<Transformer> inputTransformers, List<ResponseGenerator> responseGenerators) {
        return new InputHandler(inputTransformers, responseGenerators);
    }

    @Bean
    public Eliza eliza(InputHandler inputHandler) {
        return new Eliza(initialPrompter, inputHandler);
    }
}
