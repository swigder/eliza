package com.swigder.nlp.eliza;

import com.swigder.nlp.eliza.configuration.ElizaConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xx on 9/12/15.
 */
public class ElizaLauncher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ElizaConfiguration.class);
        ctx.getBean(Eliza.class).run();
    }
}
