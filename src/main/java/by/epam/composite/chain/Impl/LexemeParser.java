package main.java.by.epam.composite.chain.Impl;

import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.PartComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements Parser {
    private static Logger logger = LogManager.getLogger();
    private ParentComposite lexemeComposite;

    public LexemeParser() {
        lexemeComposite = new PartComposite();
    }

    @Override
    public ParentComposite handleRequest(String text) {
        for (String lexeme : text.split(LEXEME)) {
            lexemeComposite.add(new WordParser().handleRequest(lexeme));
            logger.info("Lexeme was parsed");
        }
        logger.info("Lexemes parse was completed");
        return lexemeComposite;
    }
}
