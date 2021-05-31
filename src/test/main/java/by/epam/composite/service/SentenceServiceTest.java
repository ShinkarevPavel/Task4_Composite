package main.java.by.epam.composite.service;

import main.java.by.epam.composite.chain.Impl.ParagraphParser;
import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceServiceTest {
    private final String TEXT = "\tOops I did it again It (Children of a Bodom)";
    private final String LONGEST_WORD = "children";
    private SentenceService sentenceService;
    private Parser parser;
    private ParentComposite composite;

    @BeforeTest
    public void before() {
        sentenceService = new SentenceService();
        parser = new ParagraphParser();
    }

    @Test
    public void testWordLengthFinder() {
        composite = parser.handleRequest(TEXT);
        String actual = sentenceService.wordLengthFinder(composite);
        String expected = LONGEST_WORD;
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        sentenceService = null;
        parser = null;
        composite = null;
    }
}