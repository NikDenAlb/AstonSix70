package Stage1.eight.star;

public class Main {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance(1, "hello");
        Singleton b = Singleton.getInstance (2, "hello");
        System.out.println(a == b);
    }
}
