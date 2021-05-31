package main.java.by.epam.composite.service;

import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.LeafComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LetterDefiner {
    private static Logger logger = LogManager.getLogger();
    private static final String VOWELS = "(?i:[aeiouyаоуэиыеёяю])";
    private static final String CONSONANTS = "(?i:[^aeiouyаоуэиыеёяю])";
    private static final String VOWELS_LETTER = "vowels";
    private static final String CONSONANTS_LETTER = "consonants";
    private Map<String, Integer> letters;

    public LetterDefiner() {
        letters = new HashMap<>();
    }

    public Map<String, Integer> letterCounter(ParentComposite composite) {
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
                            String letter = String.valueOf(leafComposite.getValue());
                            if (letter.matches(VOWELS)) {
                                if (letters.containsKey(VOWELS_LETTER)) {
                                    int value = letters.get(VOWELS_LETTER);
                                    letters.put(VOWELS_LETTER, ++value);
                                } else {
                                    letters.put(VOWELS_LETTER, 1);
                                }
                            }
                            if (letter.matches(CONSONANTS)) {
                                if (letters.containsKey(CONSONANTS_LETTER)) {
                                    int value = letters.get(CONSONANTS_LETTER);
                                    letters.put(CONSONANTS_LETTER, ++value);
                                } else {
                                    letters.put(CONSONANTS_LETTER, 1);
                                }
                            }
                        }
                    }
                }
            }
            logger.info("Letters was counted");
        }
        return letters;
    }
}
