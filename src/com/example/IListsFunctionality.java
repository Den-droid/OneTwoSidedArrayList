package com.example;

public interface IListsFunctionality {
    public void addFirst(int data);
    public void insert(int data, int index);
    public void addLast(int data);
    public int deleteFirst();
    public int deleteElement(int index);
    public int deleteLast();
    public void replaceFirst(int newValue);
    public void replace(int newValue, int index);
    public void replaceLast(int newValue);
    public int indexAt(int index);
    public int sum();
    public void show();
}
