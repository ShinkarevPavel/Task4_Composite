package main.java.by.epam.composite.chain.Impl;

import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.LeafComposite;
import main.java.by.epam.composite.entity.impl.PartComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeafParser implements Parser {
    private static Logger logger = LogManager.getLogger();
    private ParentComposite leafComposite;

    public LeafParser() {
        leafComposite = new PartComposite();
    }

    @Override
    public ParentComposite handleRequest(String text) {
        for (String leaf : text.split(LETTER)) {
            leafComposite.add(new LeafComposite(leaf.charAt(0)));
            logger.info("Leaf was added to word list");
        }
        logger.info("Leaf parse was completed");
        return leafComposite;
    }
}
