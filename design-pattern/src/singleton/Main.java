package singleton;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // 1. EagerInitialization
        testEagerInitialization();

        // 2. StaticBlockInitialization
        testStaticBlockInitialization();

        // 3. LazyInitialization
        testLazyInitialization();

        // 4. ThreadSafeInitialization
        testThreadSafeInitialization();

        // 5. DoubleCheckedLocking
        testDoubleCheckedLocking();
    }

    /**
     * SingletonPattern - EagerInitialization
     */
    private static void testEagerInitialization() {
        EagerInitialization singleton1 = EagerInitialization.getInstance();
        EagerInitialization singleton2 = EagerInitialization.getInstance();

        System.out.println(singleton1); // singleton.EagerInitialization@36baf30c
        System.out.println(singleton2); // singleton.EagerInitialization@36baf30c
    }

    /**
     * SingletonPattern - StaticBlockInitialization
     */
    private static void testStaticBlockInitialization() {
        StaticBlockInitialization singleton1 = StaticBlockInitialization.getInstance();
        StaticBlockInitialization singleton2 = StaticBlockInitialization.getInstance();

        System.out.println(singleton1); // singleton.StaticBlockInitialization@5ca881b5
        System.out.println(singleton2); // singleton.StaticBlockInitialization@5ca881b5
    }

    /**
     * SingletonPattern - LazyInitialization
     */
    private static void testLazyInitialization() {
        LazyInitialization[] lazyInitializations = new LazyInitialization[10];
        // 스레드 풀 생성
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int j = i;
            service.submit(() -> lazyInitializations[j] = LazyInitialization.getInstance());
        }
        service.shutdown();

        // singleton.LazyInitialization@1be6f5c3, singleton.LazyInitialization@6b884d57 ...
        for (LazyInitialization lazyInitialization : lazyInitializations) {
            System.out.println(lazyInitialization);
        }
    }

    /**
     * SingletonPattern - ThreadSafeInitialization
     */
    private static void testThreadSafeInitialization() {
        ThreadSafeInitialization[] threadSafeInitializations = new ThreadSafeInitialization[10];
        // 스레드 풀 생성
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int j = i;
            service.submit(() -> threadSafeInitializations[j] = ThreadSafeInitialization.getInstance());
        }
        service.shutdown();

        // singleton.ThreadSafeInitialization@13221655, singleton.ThreadSafeInitialization@13221655 ...
        for (ThreadSafeInitialization threadSafeInitialization : threadSafeInitializations) {
            System.out.println(threadSafeInitialization);
        }
    }

    private static void testDoubleCheckedLocking() {
        DoubleCheckedLocking[] doubleCheckedLockings = new DoubleCheckedLocking[10];
        // 스레드 풀 생성
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int j = i;
            service.submit(() -> doubleCheckedLockings[j] = DoubleCheckedLocking.getInstance());
        }
        service.shutdown();

        // singleton.DoubleCheckedLocking@e9e54c2 ...
        for (DoubleCheckedLocking doubleCheckedLocking : doubleCheckedLockings) {
            System.out.println(doubleCheckedLocking);
        }
    }
}

