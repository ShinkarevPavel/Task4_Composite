package main.java.by.epam.composite.service;


import main.java.by.epam.composite.comparator.ParagraphLengthComparator;
import main.java.by.epam.composite.entity.ParentComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class ParagraphSort {
    private final Logger logger = LogManager.getLogger();

    public List<ParentComposite> sortBySentenceInParagraph(ParentComposite composite) {
        List<ParentComposite> paragraphs = composite.getCompositeList();
        if (!paragraphs.isEmpty()) {
            paragraphs.sort(new ParagraphLengthComparator());
            logger.info("Paragraphs list was sorted");
        }
        return paragraphs;
    }
}
