package com.swigder.nlp.eliza;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Launches ELIZA using Spring configuration.
 * To use a custom profile, pass arg -Dspring.profiles.active=teenager.
 * To customize ELIZA, create a Spring configuration file in a package named
 * **.personality.**.configuration or **.eliza.extension.**.configuration,
 * and add the @ComponentScan annotation to your configuration class and
 * add additional @Component annotated InputTransformers, ResponseGenerators,
 * and OutputTransformers in the packages scanned.  Additional components
 * will be added lowest on the list unless they are annotated with @Order.
 */
public class ElizaLauncher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.swigder.nlp.eliza.configuration",
                "**.personality.**.configuration",
                "**.eliza.extension.**.configuration"
        );
        ctx.getBean(Eliza.class).run();
    }
}
