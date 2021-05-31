package main.java.by.epam.composite.service;

import main.java.by.epam.composite.chain.Impl.ParagraphParser;
import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphSortTest {

    private final String TEXT = "\tThis is the test sentence." +
                                "\tSentence of a wbad. And." +
                                "\tThis is. THe most longer. Paragrpah. Cause it have five. Yes.";
    private Parser parser;
    private ParentComposite composite;
    private ParagraphSort paragraphSort;

    @BeforeTest
    public void before() {
        paragraphSort = new ParagraphSort();
        parser = new ParagraphParser();
    }


    @Test
    public void testSortBySentenceInParagraph() {
        composite = parser.handleRequest(TEXT);
        paragraphSort.sortBySentenceInParagraph(composite);
        int actual = composite.getCompositeList().get(0).getSize();
        int expected = 5;
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        paragraphSort = null;
        parser = null;
        composite = null;
    }
}