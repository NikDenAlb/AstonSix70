package stage1.eight.starstar;

public class Main {
    public static void main(String[] args) {
        Singleton a = new Singleton.Builder().setId(1).setName("hello").build();
        System.out.println(a);
        Singleton b = new Singleton.Builder().setId(7).setName("hello").build();
        System.out.println(b);
        System.out.println(a == b);
    }
}
