package stage1.six.trainer;

import java.io.*;

public class SomeThing {

    public static void main(String[] args) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt", false))) {
            Person p = new Person("Sam", 33, 178, true);
            Person p2 = new Person("John", 40, 165, false);
            oos.writeObject(p);
            oos.writeObject(p2);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Person p = (Person) ois.readObject();
            System.out.println(p.getName());
            System.out.println(p.getAge());
            System.out.println(p.getHeight());
            System.out.println(p.getMarried());

            Person p2 = (Person) ois.readObject();
            System.out.println(p2.getName());
            System.out.println(p2.getAge());
            System.out.println(p2.getHeight());
            System.out.println(p2.getMarried());
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}

class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private double height;
    private boolean married;

    Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    }

    String getName() { return name; }
    int getAge() { return age; }
    double getHeight() { return height; }
    boolean getMarried() { return married; }
}