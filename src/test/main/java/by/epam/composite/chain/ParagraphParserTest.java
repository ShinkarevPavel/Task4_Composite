package main.java.by.epam.composite.chain;

import main.java.by.epam.composite.chain.Impl.ParagraphParser;
import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.PartComposite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {
    private Parser parser;
    private final String TEXT = "\tThis is the first paragraph." +
                                "\tThis is the second paragraph." +
                                "\tAnd this is the third paragraph.";
    @BeforeTest
    public void before() {
        parser = new ParagraphParser();
    }

    @Test
    public void testHandleRequest() {
        int actual = parser.handleRequest(TEXT).getSize();
        int expected = 3;
        Assert.assertEquals(actual, expected);
    }
    @AfterTest
    public void after() {
        parser = null;
    }
}