package eight.starstar;

public class Singleton {
    private static volatile Singleton instance; //volatile - чтение не из кеша а сразу из оперативной памяти
    private int id;
    private String name;

    private Singleton(int id, String name) {
        this.id = id;
        this.name = name;
    }


    private static Singleton getInstance(int id, String name) {
        Singleton localInstance = instance;
        //лн. оптимизация, синхр только часть метода(в большинстве случаев != null
        if (localInstance == null) {
            synchronized (Singleton.class) {     //потокобезопасность(не пускает более одного потока)
                localInstance = instance;
                if (localInstance == null) {     //лн - ленивая инициализация (по обращению)
                    instance = localInstance = new Singleton(id,name);
                }
            }
        }
        return localInstance;
    }
    public static class Builder {
        private int id;
        private String name;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Singleton build() {return getInstance(id,name);}
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}