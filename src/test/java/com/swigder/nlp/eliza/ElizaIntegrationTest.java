package com.swigder.nlp.eliza;

import com.google.common.base.Charsets;
import com.swigder.nlp.eliza.configuration.DefaultConfiguration;
import com.swigder.nlp.eliza.configuration.ElizaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * This integration test works for testing that all the bolts are in place, i.e., that Eliza
 * will prompt and then respond to various inputs one at a time using the configured handler.
 * But for more detailed tests of specific inputs it is better to just integration test the
 * InputHandler, which doesn't have to deal with IO.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (classes = {ElizaConfiguration.class, DefaultConfiguration.class, ElizaIntegrationTest.MockStreamConfiguration.class})
public class ElizaIntegrationTest {
    private static PipedOutputStream pipedOutputStream = new PipedOutputStream();
    private static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Autowired private Eliza eliza;

    @Test
    public void eliza() throws IOException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                eliza.run();
            }
        };
        new Thread(runnable).start();

        Callable<String> output = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return outputStream.toString().trim();
            }
        };

        await().atMost(1, TimeUnit.SECONDS).until(output,
                anyOf(
                        equalTo("How are you today?"),
                        equalTo("How are you feeling today?"),
                        equalTo("How are you doing today?"),
                        equalTo("Let's talk about why you're here."),
                        equalTo("Why are you here today?")
                )
        );

        outputStream.reset();
        pipedOutputStream.write("I'm sad\n".getBytes(Charsets.UTF_8));

        await().atMost(3, TimeUnit.SECONDS).until(output,
                anyOf(
                        equalTo("I am sorry that you are sad."),
                        equalTo("Since when have you been feeling sad?"),
                        equalTo("Why are you feeling sad?")
                )
        );

        outputStream.reset();
        pipedOutputStream.write("I've been feeling sad since everything went bad.\n".getBytes(Charsets.UTF_8));

        await().atMost(3, TimeUnit.SECONDS).until(output,
                anyOf(
                        equalTo("I'm sorry about that.")
                )
        );

    }

    @Configuration
    protected static class MockStreamConfiguration {
        @Bean
        public InputStream inputStream() throws IOException {
            return new PipedInputStream(pipedOutputStream);
        }

        @Bean
        public PrintStream printStream() {
            return new PrintStream(outputStream);
        }
    }
}

