package com.hz.demo;

public class Library {

    //OCP, LSP
    public static class Parent implements ClientInterface {
        public void print() {
            System.out.println("Parent");
        }
    }

    public static class Child extends Parent {
        @Override
        public void print() {
            System.out.println("Child");
        }
    }

    public static void print(ClientInterface object) {
        System.out.println("Start");
        object.print();
        System.out.println("Finish");
    }

    public interface ClientInterface {
        void print();
    }

}
