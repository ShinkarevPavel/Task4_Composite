package main.java.by.epam.composite.service;

import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.LeafComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordCounter {
    private static Logger logger = LogManager.getLogger();
    private Map<String, Integer> uniqueWord;
    private StringBuilder stringBuilder;

    public WordCounter() {
        uniqueWord = new HashMap<>();
        stringBuilder = new StringBuilder();
    }

    public Map<String, Integer> sameWordCounter(ParentComposite composite) {
        Iterator<ParentComposite> paragraphIterator = composite.iterator();
        while (paragraphIterator.hasNext()) {
            Iterator<ParentComposite> sentenceIterator = paragraphIterator.next().iterator();
            while (sentenceIterator.hasNext()) {
                Iterator<ParentComposite> lexemeIterator = sentenceIterator.next().iterator();
                while (lexemeIterator.hasNext()) {
                    Iterator<ParentComposite> wordIterator = lexemeIterator.next().iterator();
                    while (wordIterator.hasNext()) {
                        Iterator<ParentComposite> leafIterator = wordIterator.next().iterator();
                        while (leafIterator.hasNext()) {
                            LeafComposite leafComposite = (LeafComposite) leafIterator.next();
                            stringBuilder.append(leafComposite.getValue());
                        }
                        if (uniqueWord.containsKey(stringBuilder.toString().toLowerCase())) {
                            int value = uniqueWord.get(stringBuilder.toString().toLowerCase());
                            uniqueWord.put(stringBuilder.toString().toLowerCase(), ++value);
                            logger.info("Counter of the unique string was increased");
                        } else {
                            uniqueWord.put(stringBuilder.toString().toLowerCase(), 1);
                            logger.info("String was found");
                        }
                        stringBuilder.delete(0, stringBuilder.capacity());
                    }
                }
            }
        }
        return uniqueWord;
    }
}
