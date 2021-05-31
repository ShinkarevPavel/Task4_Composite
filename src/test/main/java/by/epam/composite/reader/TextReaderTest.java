package main.java.by.epam.composite.reader;

import main.java.by.epam.composite.exception.CompositeException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextReaderTest {
    private final String PATH_TO_FILE = "./src/test/main/resources/text.txt";
    private final String WRONG_PATH_TO_FILE = "./src/test/main/resources/ext.txt";
    private final String NULL_INSTEAD_FILE = null;
    private final String EXPECTED_STRING = "\tIt has survived!\n" +
                                            "\tIt is a long a!=b ?\n" +
                                            "\tIt is a established ...\n" +
                                            "\tBye бандерлоги.";

    private TextReader textReader;

    @BeforeTest
    public void before() {
        textReader = new TextReader();
    }

    @Test
    public void testTxtReader() throws CompositeException {
        String actual = textReader.txtReader(PATH_TO_FILE);
        Assert.assertEquals(actual, EXPECTED_STRING);
    }
    @Test (expectedExceptions = CompositeException.class)
    public void testExceptionTxtReader() throws CompositeException{
        String actual = textReader.txtReader(WRONG_PATH_TO_FILE);
    }

    @Test (expectedExceptions = CompositeException.class)
    public void testExceptionReader() throws CompositeException{
        String actual = textReader.txtReader(NULL_INSTEAD_FILE);
    }

    @AfterTest
    public void after() {
        textReader = null;
    }
}