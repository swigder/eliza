package com.swigder.nlp.eliza.personality.teenager.transformer;

import com.swigder.nlp.eliza.transformer.OutputTransformer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Transforms words into their chatspeak equivalent
 * Ex: 'you' into 'u' (includes derived words like 'your', 'yourself').
 *     'are' into 'r'
 *     'why' into 'y'
 */
@Component
@Order(value = 1)
public class ChatspeakTransformer implements OutputTransformer {

    @Override
    public String transform(String input) {
        input = input.replaceAll("you", "u");
        input = input.replaceAll("\\sare\\s", " r ");
        input = input.replaceAll("why\\s", "y ");
        input = input.replaceAll("i am", "im");
        input = input.replaceAll("please", "pls");
        return input;
    }
}
