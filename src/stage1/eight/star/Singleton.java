package stage1.eight.star;

public class Singleton {
    private static volatile Singleton instance; //volatile - чтение не из кеша а сразу из оперативной памяти
    private int id;
    private String name;

    private Singleton(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public static Singleton getInstance(int id, String name) {
        Singleton localInstance = instance;
        if (localInstance == null) {             //ленивая инициализация (по обращению), оптимизация, синхр только часть метода(в большинстве случаев != null
            synchronized (Singleton.class) {     //потокобезопасность(не пускает более одного потока)
                localInstance = instance;
                if (localInstance == null) {     //ленивая инициализация (по обращению)
                    instance = localInstance = new Singleton(id,name);
                }
            }
        }
        return localInstance;
    }


}