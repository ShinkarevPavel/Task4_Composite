package main.java.by.epam.composite.entity.impl;

import main.java.by.epam.composite.entity.ParentComposite;

import java.util.Iterator;
import java.util.List;

public class LeafComposite implements ParentComposite {
    private char value;

    public LeafComposite(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public boolean add(ParentComposite composite) {
        throw new UnsupportedOperationException("This method not supported");
    }

    @Override
    public boolean remove(ParentComposite composite) {
        throw new UnsupportedOperationException("This method not supported");
    }

    @Override
    public ParentComposite getInstance(int index) {
        return this;
    }

    @Override
    public List<ParentComposite> getCompositeList() {
        throw new UnsupportedOperationException("This method not supported");
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("This method not supported");
    }

    @Override
    public Iterator<ParentComposite> iterator() {
        throw new UnsupportedOperationException("This method not supported");
    }
}
