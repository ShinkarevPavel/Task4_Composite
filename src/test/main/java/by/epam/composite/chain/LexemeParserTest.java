package main.java.by.epam.composite.chain;

import main.java.by.epam.composite.chain.Impl.LexemeParser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LexemeParserTest {
    private Parser lexemeParser;
    private final String TEXT = "This sentence, like example -without correct sense.";

    @BeforeTest
    public void before() {
        lexemeParser = new LexemeParser();
    }

    @Test
    public void testHandleRequest() {
        int actual = lexemeParser.handleRequest(TEXT).getSize();
        int expected = 7;
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        lexemeParser = null;
    }
}