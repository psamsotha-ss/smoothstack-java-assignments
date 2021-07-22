package javabasics4;

/**
 * Implement a Singleton with double checked locking.
 */
public class Assignment1 {

    public static class DoubleCheckedSingleton {

        private static volatile DoubleCheckedSingleton INSTANCE;

        private DoubleCheckedSingleton() {}

        public static DoubleCheckedSingleton getInstance() {
            if (INSTANCE == null) {
                synchronized (DoubleCheckedSingleton.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new DoubleCheckedSingleton();
                    }
                }
            }
            return INSTANCE;
        }
    }
}
