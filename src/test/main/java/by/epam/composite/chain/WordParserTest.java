package main.java.by.epam.composite.chain;

import main.java.by.epam.composite.chain.Impl.WordParser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WordParserTest {
    private final String TEXT = "This sentence, like example -without correct sense.";
    private Parser wordParser;

    @BeforeTest
    public void before() {
        wordParser = new WordParser();
    }

    @Test
    public void testHandleRequest() {
        int actual = wordParser.handleRequest(TEXT).getSize();
        int expected = 7;
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        wordParser = null;
    }
}