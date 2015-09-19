package com.swigder.nlp.eliza.personality.teenager.responder;

import com.swigder.nlp.eliza.responder.impl.OneWordInputResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * This teenaged version of the response generator is a bit less forgiving of users
 * that can't be bothered to say more than one word.
 */
@Component
@Order(value = 2)
public class TeenagedOneWordResponseGenerator extends OneWordInputResponseGenerator {
    @Override
    public String generateResponse(String input) {
        String response = super.generateResponse(input);

        if (defaultAnswer.equals(response)) {
            return "You srsly need to say something more than just " + input + ".";
        }

        return response;
    }

}
