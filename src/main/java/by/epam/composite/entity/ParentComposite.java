package main.java.by.epam.composite.entity;

import java.util.Iterator;
import java.util.List;

public interface ParentComposite {
    boolean add(ParentComposite composite);
    boolean remove(ParentComposite composite);
    ParentComposite getInstance(int index);
    int getSize();
    List<ParentComposite> getCompositeList();
    Iterator<ParentComposite> iterator();
}
