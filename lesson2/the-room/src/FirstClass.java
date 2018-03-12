public class FirstClass {

    public static void main(String[] args) {
        printAB();
        print("C");
        print("D");
    }

    public static void printAB() {
        print("A");
        print("B");
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
