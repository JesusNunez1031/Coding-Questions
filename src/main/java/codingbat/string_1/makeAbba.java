package codingbat.string_1;

public class makeAbba {

    /*

Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".

    codingbat.string_1.makeAbba("Hi", "Bye") → "HiByeByeHi"
    codingbat.string_1.makeAbba("Yo", "Alice") → "YoAliceAliceYo"
    codingbat.string_1.makeAbba("What", "Up") → "WhatUpUpWhat"
     */

    public String makeAbba(String a, String b) {
        String doubleB = b + b;
        return a + doubleB + a;
    }
}
