package com.example.kotlin.javacode;

public class DummyClass {

    public String isVacationTime(boolean onVacation) {
        return onVacation ? "I am on vacation" : "I am working";
    }

    public void printNumbers(int[] numbers) {
        System.out.println("Printing int[] numbers array:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
