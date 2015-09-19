package com.swigder.nlp.eliza.response.impl;

import com.swigder.nlp.eliza.collections.ScalarListMapBuilder;
import com.swigder.nlp.eliza.response.abstr.RandomResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Responds to a variety of inputs related to feelings about one's self and acquaintances
 */
@Component
@Order (value = 1)
public class FeelingResponseGenerator extends RandomResponseGenerator {

    private static final Map<Pattern, List<String>> patterns = new ScalarListMapBuilder<Pattern, String>()
            .put(Pattern.compile("I (.\\w+) my ([\\w\\-']+)"), "Why do you $1 your $2?")
            .put(Pattern.compile("I(?:'m| am)? (?:feel(?:ing))? ?(sad|depressed|annoyed|miserable|bad).*"), "I am sorry that you are $1.", "Since when have you been feeling $1?", "Why are you feeling $1?")
            .put(Pattern.compile("I(?:'m|'ve been| am)? (?:am|feel(?:ing)?)? ?(happy|doing well|good|well|fine).*"), "I am glad that you are $1.")
            .put(Pattern.compile("I feel .*"), "Why do you feel that way?", "Tell me more about that feeling.")
            .put(Pattern.compile("(?:I am|I'm) (?:a little|very|quite) ?(\\w+)"), "Why are you $1?", "Do you think it is good that you are $1?")
            .put(Pattern.compile("I(?: am|'m) (?:very|quite|a little)? ?(.*)"), "Why are you $1?")
            .put(Pattern.compile("I think .*"), "Why do you think that?")
            .put(Pattern.compile(".*[Mm]y life (\\w+)s"), "Why does your life $1?")
            .put(Pattern.compile(".*[Mm]y life .+"), "Tell me more about that.")
            .put(Pattern.compile(".*bad.*"), "I'm sorry about that.")
            .build();

    public FeelingResponseGenerator() {
        super(patterns);
    }
}
