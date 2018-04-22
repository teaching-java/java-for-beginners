package com.hz.demo;

public class Main {

    //using library, DIP
    public static void main(String[] args) {
        Library.ClientInterface parent = new Library.Parent();
        Library.print(parent);
    }
}
