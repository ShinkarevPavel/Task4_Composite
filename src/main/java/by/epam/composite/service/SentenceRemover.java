package main.java.by.epam.composite.service;

import main.java.by.epam.composite.entity.ParentComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

public class SentenceRemover {
    private static Logger logger = LogManager.getLogger();

    public boolean remove(ParentComposite composite, int wordCount) {
        boolean flag = false;
        Iterator<ParentComposite> paragraphIterator = composite.iterator();
        while (paragraphIterator.hasNext()) {
            Iterator<ParentComposite> sentenceIterator = paragraphIterator.next().iterator();
            while (sentenceIterator.hasNext()) {
                if (sentenceIterator.next().getSize() < wordCount) {
                    sentenceIterator.remove();
                    flag = true;
                    logger.info("Sentence with word capacity less " + wordCount + "was removed");
                }
            }
        }
        return flag;
    }
}
