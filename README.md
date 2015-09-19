# eliza

This is an implentation of the ELIZA program, which simulates a Rogerian psychotherapist.  It uses simple regular expression substitution to convert user input into appropriate responses and attempt to engage in user-focused conversation.

Capitalization and punctuation is optional, but text should not be input in ALL CAPS.  Only one sentence should be input at a time.

To run this program, run `./gradlew --console plain run`.

To run with the built-in sullen teenager personality, run `./gradlew --console plain run -Dspring.profiles.active=teenager`.
