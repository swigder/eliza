package com.swigder.nlp.eliza.configuration;

import com.google.common.collect.Lists;
import com.swigder.nlp.eliza.Eliza;
import com.swigder.nlp.eliza.InputHandler;
import com.swigder.nlp.eliza.prompter.Prompter;
import com.swigder.nlp.eliza.responder.ResponseGenerator;
import com.swigder.nlp.eliza.transformer.InputTransformer;
import com.swigder.nlp.eliza.transformer.OutputTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Spring configuration for ELIZA.
 * The Prompter, InputTransformers, ResponseGenerators, and OutputTransformers
 * will be autowired from those available on the Spring Context.  See ElizaLauncher
 * for more detail.
 */
@Configuration
public class ElizaConfiguration {

    @Autowired protected Prompter initialPrompter;
    @Autowired(required=false) protected List<InputTransformer> inputTransformers = Lists.newArrayList();
    @Autowired protected List<ResponseGenerator> responseGenerators;
    @Autowired(required=false) protected List<OutputTransformer> responseTransformers = Lists.newArrayList();

    @Bean
    public InputHandler inputHandler() {
        return new InputHandler(inputTransformers, responseGenerators, responseTransformers);
    }

    @Bean
    public Eliza eliza() {
        return new Eliza(initialPrompter, inputHandler());
    }
}
