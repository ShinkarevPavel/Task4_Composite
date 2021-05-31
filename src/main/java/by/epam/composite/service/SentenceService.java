package main.java.by.epam.composite.service;

import main.java.by.epam.composite.entity.ParentComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class SentenceService {
    private static Logger logger = LogManager.getLogger();
    private WordCounter wordCounter;

    public SentenceService() {
        this.wordCounter = new WordCounter();
    }

    public String wordLengthFinder(ParentComposite composite) {
        Map<String, Integer> uniqueWords = wordCounter.sameWordCounter(composite);
        String longestWord = "";
        int wordLength = 0;
        for (Map.Entry<String, Integer> word : uniqueWords.entrySet()) {
            if (word.getKey().length() > wordLength) {
                wordLength = word.getKey().length();
                longestWord = word.getKey();
                logger.info("Longest word was updated");
            }
        }
        return longestWord;
    }
}
