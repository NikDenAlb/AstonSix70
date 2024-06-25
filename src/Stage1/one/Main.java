package Stage1.one;

public class Main {
    public static void main(String[] args) {
        System.out.println(Example.class.getClassLoader());
        System.out.println(Example.class.getClassLoader().getName());
        System.out.println(Example.class.getName());
    }
}