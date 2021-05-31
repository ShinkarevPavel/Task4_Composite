package main.java.by.epam.composite.chain;

import main.java.by.epam.composite.chain.Impl.SentenceParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SentenceParserTest {
    private Parser sentenceParser;
    private final String TEXT = "This sentence, created. For parsing! Or not? I don`t know...";

    @BeforeTest
    public void before() {
        sentenceParser = new SentenceParser();
    }

    @Test
    public void testHandleRequest() {
        int actual = sentenceParser.handleRequest(TEXT).getSize();
        int expected = 4;
        Assert.assertEquals(actual, expected);

    }

    @BeforeTest
    public void after() {
        sentenceParser = null;
    }
}