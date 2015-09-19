# eliza

This is an implentation of the ELIZA program, which simulates a Rogerian psychotherapist.  It uses simple regular expression substitution to convert user input into appropriate responses and attempt to engage in user-focused conversation.

Capitalization and terminal punctuation is optional, but text should not be input in ALL CAPS.  Only one sentence should be input at a time.

#### Building and running

To build, run `./gradlew build`.  This will download all dependencies, compile the program, and run all tests.

To run this program, run `./gradlew --console plain run`.

To run with the built-in sullen teenager personality, run `./gradlew --console plain run -Dspring.profiles.active=teenager`.

#### Extending

ELIZA works by transforming user input using a configured list of `InputTransformer`s, finding the first of a configured list of `ResponseGenerator`s that can respond to the the transformed input, transforming the output using a configured list of `OutputTransformer`s, and then displaying this output to the user.

It is easy to extend ELIZA by implementing these three interfaces and ensuring that the implementations are available on the context.  Please see JavaDoc, particularly documentation for `ElizaLauncher`, `ElizaConfiguration`, and the three interfaces mentioned above, for more details.
