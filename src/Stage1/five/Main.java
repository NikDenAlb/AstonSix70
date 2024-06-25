package Stage1.five;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//Итоговый вывод - [33, 22]
        List<Data> dataList = List.of(new Data("22", "1"), new Data("11", "3"), new Data("33", "1"));
        List<Data> dataList1 = List.of(new Data("11", "3"), new Data("22", "3"), new Data("33", "2"));
        System.out.println(findData(dataList, dataList1));
    }

    public static Collection<String> findData(List<Data> data, List<Data> data2) {


        return Stream.of(data, data2).flatMap(Collection::stream)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(e->e.getKey().getCode())
                .collect(Collectors.toSet());
    }

    public static class Data {
        String code;
        String version;

        public Data(String code, String version) {
            this.code = code;
            this.version = version;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return Objects.equals(code, data.code) && Objects.equals(version, data.version);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code, version);
        }

        @Override
        public String toString() {
            return "Data{" + "code='" + code + '\'' + ", version='" + version + '\'' + '}';
        }
    }
}