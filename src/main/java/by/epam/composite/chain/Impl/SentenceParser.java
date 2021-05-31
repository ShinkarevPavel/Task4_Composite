package main.java.by.epam.composite.chain.Impl;

import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.PartComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements Parser {
    private static Logger logger = LogManager.getLogger();
    private ParentComposite sentenceComposite;

    public SentenceParser() {
        sentenceComposite = new PartComposite();
    }

    @Override
    public ParentComposite handleRequest(String text) {
        for (String sentence : text.split(SENTENCE)) {
            sentenceComposite.add(new LexemeParser().handleRequest(sentence));
            logger.info("Sentence was parsed");
        }
        logger.info("Sentences parse was completed");
        return sentenceComposite;
    }
}
