package main.java.by.epam.composite.chain;

import main.java.by.epam.composite.entity.ParentComposite;

public interface Parser {
    String PARAGRAPH = ("\t");
    String SENTENCE = ("(?<=[.{1-3}!?]\\s)");
    String LEXEME = ("\\s");
    String WORD = ("[\\s\\p{Punct}]");
    String PUNCTUATION = ("[\\w\\s]");
    String DIGIT =("\\D");
    String LETTER = ("");

    ParentComposite handleRequest(String text);
}
