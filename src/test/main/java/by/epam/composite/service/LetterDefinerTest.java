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

public class LetterDefinerTest {
    private final String TEXT = "This is the test sentence.";
    private final String VOWELS = "vowels";
    private final String CONSONANTS = "consonants";
    private LetterDefiner letterDefiner;
    private ParentComposite composite;
    private Parser parser;


    @BeforeTest
    public void before() {
        letterDefiner = new LetterDefiner();
        parser = new ParagraphParser();
    }

    @Test
    public void testVowelsLetterCounter() {
        composite = parser.handleRequest(TEXT);
        int actual = letterDefiner.letterCounter(composite).get(VOWELS);
        int expected = 7;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testConsonantsCounter() {
        composite = parser.handleRequest(TEXT);
        int actual = letterDefiner.letterCounter(composite).get(CONSONANTS);
        int expected = 14;
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        letterDefiner = null;
        parser = null;
        composite = null;
    }
}