package main.java.by.epam.composite.chain.Impl;

import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.PartComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements Parser {
    private static Logger logger = LogManager.getLogger();
    private ParentComposite wordComposite;

    public WordParser() {
        wordComposite = new PartComposite();
    }

    @Override
    public ParentComposite handleRequest(String text) {
        for (String word : text.split(WORD)) {
            if (word.isEmpty()){
                continue;
            }
            wordComposite.add(new LeafParser().handleRequest(word));
            logger.info("Word was parsed");
        }
        logger.info("Words parse was completed");
        return wordComposite;
    }
}
