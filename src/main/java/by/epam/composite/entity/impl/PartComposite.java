package main.java.by.epam.composite.entity.impl;

import main.java.by.epam.composite.entity.ParentComposite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PartComposite implements ParentComposite {

    private List<ParentComposite> compositeList = new ArrayList<>();

    @Override
    public boolean add(ParentComposite composite) {
        return compositeList.add(composite);
    }

    @Override
    public List<ParentComposite> getCompositeList() {
        return compositeList;
    }

    @Override
    public boolean remove(ParentComposite composite) {
        return compositeList.remove(composite);
    }

    @Override
    public ParentComposite getInstance(int index) {
        return compositeList.get(index);
    }

    @Override
    public int getSize() {
        return compositeList.size();
    }

    @Override
    public Iterator<ParentComposite> iterator() {
        return compositeList.iterator();
    }
}
