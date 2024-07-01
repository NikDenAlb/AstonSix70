package stage2.mylists;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> listArray  = new MyArrayList<>();
        System.out.println("listArray.toStringGuts() = " + listArray.toStringGuts());
        System.out.println("listArray = " + listArray);
        System.out.println("listArray.add(1) = " + listArray.add(1));
        System.out.println("listArray.add(2) = " + listArray.add(2));
        System.out.println("listArray.add(6) = " + listArray.add(6));
        System.out.println("listArray.toStringGuts() = " + listArray.toStringGuts());
        System.out.println("listArray = " + listArray);
        System.out.println("listArray.add(8) = " + listArray.add(8));
        System.out.println("listArray.add(7) = " + listArray.add(7));
        System.out.println("listArray.add(7) = " + listArray.add(7));
        System.out.println("listArray.toStringGuts() = " + listArray.toStringGuts());
        System.out.println("listArray.sort()");
        listArray.sort();
        System.out.println("listArray = " + listArray);
        System.out.println("listArray.toStringGuts() = " + listArray.toStringGuts());
        System.out.println("listArray.add(3,50);");
        listArray.add(3,50);
        System.out.println("listArray.toStringGuts() = " + listArray.toStringGuts());
        System.out.println("listArray.remove(2) = " + listArray.remove(2));
        System.out.println("listArray.toStringGuts() = " + listArray.toStringGuts());
        System.out.println("listArray = " + listArray);
        System.out.println("listArray.clear();");
        listArray.clear();
        System.out.println("listArray.toStringGuts() = " + listArray.toStringGuts());
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        MyLinkedList<Integer> listLinked = new MyLinkedList<>();
        System.out.println("listLinked.add(1) = " + listLinked.add(1));
        System.out.println("listLinked.add(100) = " + listLinked.add(100));
        System.out.println("listLinked.add(5) = " + listLinked.add(5));
        System.out.println("listLinked = " + listLinked);
        System.out.println("listLinked.add(1,55);");
        listLinked.add(1,55);
        System.out.println("listLinked = " + listLinked);
        System.out.println("listLinked.sort();");
        listLinked.sort();
        System.out.println("listLinked = " + listLinked);
        System.out.println("listLinked.remove(2) = " + listLinked.remove(2));
        System.out.println("listLinked = " + listLinked);
        System.out.println("listLinked.clear();");
        listLinked.clear();
        System.out.println("listLinked = " + listLinked);
    }
}