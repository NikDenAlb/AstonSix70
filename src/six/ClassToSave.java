package six;


import java.io.Serializable;

public class ClassToSave implements Serializable {

    private String field1;
    private int field2;
    private double field3;
    private boolean field4;

    ClassToSave(String field1, int field2, double field3, boolean field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    @Override
    public String toString() {
        return "ClassToSave{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3=" + field3 +
                ", field4=" + field4 +
                '}';
    }
}
