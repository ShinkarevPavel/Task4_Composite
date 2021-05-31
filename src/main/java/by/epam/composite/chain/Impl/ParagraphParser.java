package main.java.by.epam.composite.chain.Impl;

import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.PartComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements Parser {
    private static Logger logger = LogManager.getLogger();
    private ParentComposite paragraphComposite;


    public ParagraphParser() {
        this.paragraphComposite = new PartComposite();
    }

    @Override
    public ParentComposite handleRequest(String text) {
    for (String paragraph : text.split(PARAGRAPH)) {
        if (paragraph.isEmpty()){
            continue;
        }
        paragraphComposite.add(new SentenceParser().handleRequest(paragraph));
        logger.info("Paragraph was parsed");
    }
    logger.info("Paragraphs parse was completed");
        return paragraphComposite;
    }
}
