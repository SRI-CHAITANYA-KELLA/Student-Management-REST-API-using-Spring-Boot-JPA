package com.demo.Exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message); // ✅ Pass message to parent class
    }
}