package main.java.by.epam.composite.service;

import main.java.by.epam.composite.chain.Impl.ParagraphParser;
import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class WordCounterTest {
    private final String TEXT = "\tOops I did it again It (Children of a Bodom)";
    private WordCounter wordCounter;
    private Parser parser;
    private Map<String, Integer> letters;
    private ParentComposite composite;

    @BeforeTest
    public void before() {
        wordCounter = new WordCounter();
        letters = new HashMap<>();
        parser = new ParagraphParser();
    }

    @Test
    public void testSameWordCounter() {
        composite = parser.handleRequest(TEXT);
        letters = wordCounter.sameWordCounter(composite);
        int actual = letters.get("it");
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        wordCounter = null;
        letters = null;
        parser = null;
        composite = null;
    }
}