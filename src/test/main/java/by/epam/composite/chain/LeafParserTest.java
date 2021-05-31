package main.java.by.epam.composite.chain;

import main.java.by.epam.composite.chain.Impl.LeafParser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LeafParserTest {
    private final String TEXT = "This sentence, like example -without correct sense.";
    private Parser leafParser;


    @BeforeTest
    public void before() {
        leafParser = new LeafParser();
    }

    @Test
    public void testHandleRequest() {
        int actual = leafParser.handleRequest(TEXT).getSize();
        int expected = 51;
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        leafParser = null;
    }
}