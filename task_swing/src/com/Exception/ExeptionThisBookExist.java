package com.Exception;

public class ExeptionThisBookExist extends Exception {
    @Override
    public String toString() {
        return "Error, the book already exists in the database";
    }
}
