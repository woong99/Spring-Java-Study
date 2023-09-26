package singleton;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        // 1. EagerInitialization
        EagerInitialization singleton1 = EagerInitialization.getInstance();
        EagerInitialization singleton2 = EagerInitialization.getInstance();

        System.out.println(singleton1); // singleton.EagerInitialization@36baf30c
        System.out.println(singleton2); // singleton.EagerInitialization@36baf30c

        // 2. StaticBlockInitialization
        StaticBlockInitialization singleton3 = StaticBlockInitialization.getInstance();
        StaticBlockInitialization singleton4 = StaticBlockInitialization.getInstance();

        System.out.println(singleton3); // singleton.StaticBlockInitialization@5ca881b5
        System.out.println(singleton4); // singleton.StaticBlockInitialization@5ca881b5

        // 3. LazyInitialization
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
}

