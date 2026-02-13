package com.codefinity.task;

import java.math.BigInteger;
import java.util.Arrays;

public class TaskThread {

    public final static int SIZE_MASSIVE = 100; //DO NOT CHANGE
    public static final BigInteger[] results = new BigInteger[SIZE_MASSIVE]; //DO NOT CHANGE

    public static void main(String[] args) throws InterruptedException {  //DO NOT CHANGE
        calculateFactorialsInParallel();



                    printMassive(results);
    }

    public static void calculateFactorialsInParallel() throws InterruptedException{
        //TODO: Write the logic for creating 100 threads and merging the entire array 'results'
        Thread[] threads = new Thread[SIZE_MASSIVE];

        for (int i = 0; i < SIZE_MASSIVE; i++) {
            int index = i;
            threads[i] = new Thread(() -> results[index] =  factorial(index));
            threads[i].start();

        }

        for (int i = 0; i < SIZE_MASSIVE; i++) {
            threads[i].join();
        }

    }

    public static BigInteger factorial(Integer length) {  //DO NOT CHANGE
        BigInteger result = new BigInteger("1");

        for(int i = 1; i <= length; i++) {
            result = result.multiply(new BigInteger("" + i));
        }

        return result;
    }

    public static void printMassive(BigInteger[] array) {  //DO NOT CHANGE
        System.out.println(Arrays.toString(array));
    }

    public static BigInteger[] getResults() {  //DO NOT CHANGE
        return results;
    }

}


