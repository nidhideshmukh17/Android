package com.example.firebase;

public class User {
    public String first;
    public String last;
    public int born;

    // Default constructor (required by Firestore)
    public User() {
    }

    // Parameterized constructor
    public User(String first, String last, int born) {
        this.first = first;
        this.last = last;
        this.born = born;
    }

    // Getters and Setters (optional, but recommended)
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }
}

