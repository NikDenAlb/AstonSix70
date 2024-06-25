package Stage1.one;

import static Stage1.one.ExampleService.checkField;

public class Example {
    private String field1;
    private int field2;
    private Long field3;

    public void setField1(String field1) {
        if (!checkField(field1)) {
            throw new IllegalArgumentException("the name is too short");
        }
        this.field1 = field1;
    }

    public void setField2(int field2) {
        if (!checkField(field2)) {
            throw new IllegalArgumentException("must be positive");
        }
        this.field2 = field2;
    }

    public void setField3(Long field3) {
        if (field3 < 18) {
            throw new IllegalArgumentException("random limitation");
        }
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    public Long getField3() {
        return field3;
    }
}