package com.example;

public class MyArrayList{
    private int capacity;
    private final float loadFactor = 0.75F;
    private int[] array;
    private int size = 0;

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getLoadFactor() {
        return loadFactor;
    }

    public MyArrayList() {
        this.capacity = 16;
        this.array = new int[this.capacity];
    }

    public MyArrayList(int capacity) {
        if (capacity > 1) {
            this.capacity = capacity;
        }
        this.array = new int[this.capacity];
    }

    private void checkSpace() {
        if (this.getCapacity() * this.getLoadFactor() <= this.size) {
            this.extendCapacity();
        }
    }

    private void extendCapacity() {
        int[] prevArray = this.array;
        int newCapacity = this.getCapacity() * 2;
        this.array = new int[newCapacity];
        System.arraycopy(prevArray, 0, this.array, 0, this.size);
        this.setCapacity(newCapacity);
    }

    public void addTop(int value) {
        this.insert(value, 1);
    }

    public void insert(int value, int index) {
        if (index < 1 || index > this.size + 1) {
            return;
        }

        if (index == this.size + 1) {
            this.addEnd(value);
            return;
        }
        int newIndex = index - 1;
        for (int i = this.size; i > newIndex; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[newIndex] = value;
        this.size++;

        this.checkSpace();
    }

    public void addEnd(int value) {
        this.array[size] = value;
        this.size++;
        this.checkSpace();
    }

    public int deleteFirst() {
        return this.deleteElement(1);
    }

    public int deleteElement(int index) {
        if (index < 1 || index > this.size) {
            return -1;
        }

        if (index == this.size) {
            return this.deleteLast();
        }
        int newIndex = index - 1;
        int value = this.array[newIndex];
        for (int i = newIndex; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.size - 1] = 0;
        this.size--;
        return value;
    }

    public int deleteLast() {
        int value = this.array[this.size - 1];
        this.array[this.size - 1] = 0;
        this.size--;
        return value;
    }

    public void replace(int newValue, int index) {
        if (index > this.size || index < 1) {
            return;
        }
        index--;
        this.array[index] = newValue;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < this.size; i++) {
            sum += this.array[i];
        }
        return sum;
    }

    public int indexAt(int value) {
        int index = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                index = i;
                break;
            }
        }
        return index + 1;
    }

    public void show() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}