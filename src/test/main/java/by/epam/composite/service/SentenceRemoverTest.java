package main.java.by.epam.composite.service;

import main.java.by.epam.composite.chain.Impl.ParagraphParser;
import main.java.by.epam.composite.chain.Parser;
import main.java.by.epam.composite.entity.ParentComposite;
import main.java.by.epam.composite.entity.impl.PartComposite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceRemoverTest {
    private final String TEXT = "\tThis is the first paragraph. Oops I did it again." +
                                "\tThis is the second paragraph. Java! Kotlin." +
                                "\tAnd this is the third paragraph. Word for. This.";
    private SentenceRemover sentenceRemover;
    private ParentComposite composite;
    private Parser parser;

    @BeforeTest
    public void before() {
        sentenceRemover = new SentenceRemover();
        parser = new ParagraphParser();
    }
    @Test
    public void testRemove() {
        composite = parser.handleRequest(TEXT);
        Assert.assertTrue(sentenceRemover.remove(composite, 2));
    }
    @AfterTest
    public void after() {
        sentenceRemover = null;
        parser = null;
        composite = null;
    }
}