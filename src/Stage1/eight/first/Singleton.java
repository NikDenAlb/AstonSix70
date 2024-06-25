package Stage1.eight.first;

public class Singleton {
    private static volatile Singleton instance; //volatile - чтение не из кеша а сразу из оперативной памяти

    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if (localInstance == null) {             //ленивая инициализация (по обращению), оптимизация, синхр только часть метода(в большинстве случаев != null
            synchronized (Singleton.class) {     //потокобезопасность(не пускает более одного потока)
                localInstance = instance;
                if (localInstance == null) {     //ленивая инициализация (по обращению)
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }


}