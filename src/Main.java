import one.Example;

public class Main {
    public static void main(String[] args) {
        System.out.println(Example.class.getClassLoader());
        System.out.println(Example.class.getClassLoader().getName());
    }
}