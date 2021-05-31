package main.java.by.epam.composite.comparator;

import main.java.by.epam.composite.entity.ParentComposite;

import java.util.Comparator;

public class ParagraphLengthComparator implements Comparator<ParentComposite> {

    @Override
    public int compare(ParentComposite o1, ParentComposite o2) {
        return o2.getSize() - o1.getSize();
    }
}
