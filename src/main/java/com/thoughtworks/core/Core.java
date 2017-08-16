package com.thoughtworks.core;

/**
 * Created by hliang on 13/12/2016.
 */
public class Core {
    public String convertToNumberDescription(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        }
        return ""+number;
    }
}
