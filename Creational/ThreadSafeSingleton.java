package Creational;

public class ThreadSafeSingleton {
    public static void main(String[] args) {
        System.out.println("""
                If you see the same value, then singleton was reused (yay!)
                If you see different values, then 2 singletons were created (dooom!!)

                RESULT:
                """);
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}

