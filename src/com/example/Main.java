package com.example;

public class Main {

    public static void main(String[] args) {
        testOneSide();
        testTwoSided();
        testMyArrayList();
    }

    public static void testOneSide(){
        OneSidedList list = new OneSidedList();
        long addTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.insert(i, i);
        }
        addTime = System.nanoTime() - addTime;

        long deleteTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.deleteElement(i);
        }
        deleteTime = System.nanoTime() - deleteTime;

        for(int i = 1;i<10000;i++){
            list.insert(i, i);
        }

        long replaceTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.replace(i + 2, i);
        }
        replaceTime = System.nanoTime() - replaceTime;

        long indexAtTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.indexAt(i+2);
        }
        indexAtTime = System.nanoTime() - indexAtTime;

        long sumTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.sum();
        }
        sumTime = System.nanoTime() - sumTime;

        System.out.println("One sided:");
        System.out.println("Add time: " + addTime + " ns");
        System.out.println("Delete time: " + deleteTime + " ns");
        System.out.println("Replace time: " + replaceTime + " ns");
        System.out.println("Index at time: " + indexAtTime + " ns");
        System.out.println("Sum time: " + sumTime + " ns");
        System.out.println();
    }

    public static void testTwoSided(){
        TwoSidedList list = new TwoSidedList();
        long addTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.insert(i, i);
        }
        addTime = System.nanoTime() - addTime;

        long deleteTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.deleteElement(i);
        }
        deleteTime = System.nanoTime() - deleteTime;

        for(int i = 1;i<10000;i++){
            list.insert(i, i);
        }

        long replaceTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.replace(i + 2, i);
        }
        replaceTime = System.nanoTime() - replaceTime;

        long indexAtTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.indexAt(i+2);
        }
        indexAtTime = System.nanoTime() - indexAtTime;

        long sumTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.sum();
        }
        sumTime = System.nanoTime() - sumTime;

        System.out.println("Two sided:");
        System.out.println("Add time: " + addTime + " ns");
        System.out.println("Delete time: " + deleteTime + " ns");
        System.out.println("Replace time: " + replaceTime + " ns");
        System.out.println("Index at time: " + indexAtTime + " ns");
        System.out.println("Sum time: " + sumTime + " ns");
        System.out.println();
    }

    public static void testMyArrayList(){
        MyArrayList list = new MyArrayList();
        long addTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.insert(i, i);
        }
        addTime = System.nanoTime() - addTime;

        long deleteTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.deleteElement(i);
        }
        deleteTime = System.nanoTime() - deleteTime;

        for(int i = 1;i<10000;i++){
            list.insert(i, i);
        }

        long replaceTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.replace(i + 2, i);
        }
        replaceTime = System.nanoTime() - replaceTime;

        long indexAtTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.indexAt(i+2);
        }
        indexAtTime = System.nanoTime() - indexAtTime;

        long sumTime = System.nanoTime();
        for(int i = 1;i<10000;i++){
            list.sum();
        }
        sumTime = System.nanoTime() - sumTime;

        System.out.println("Array list:");
        System.out.println("Add time: " + addTime + " ns");
        System.out.println("Delete time: " + deleteTime + " ns");
        System.out.println("Replace time: " + replaceTime + " ns");
        System.out.println("Index at time: " + indexAtTime + " ns");
        System.out.println("Sum time: " + sumTime + " ns");
        System.out.println();
    }
}