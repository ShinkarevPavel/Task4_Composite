package main.java.by.epam.composite.reader;

import main.java.by.epam.composite.exception.CompositeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {
    private static Logger logger = LogManager.getLogger();
    public String txtReader(String path) throws CompositeException{
        String content = "";
        if (path != null && new File(path).exists()) {
            try {
                content = new String(Files.readAllBytes(Paths.get(path)));
                logger.info("File was successfully read");
                return content;
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new CompositeException("File reading error " + e.getMessage());
            }
        }
        throw new CompositeException("File reading error");
    }
}
