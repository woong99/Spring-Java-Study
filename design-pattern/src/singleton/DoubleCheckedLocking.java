package singleton;

public class DoubleCheckedLocking {
    private static volatile DoubleCheckedLocking instance; // volatile 키워드 적용

    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getInstance() {
        if (instance == null) {
            // 메소드에 동기화 거는게 아닌, 클래스 자체를 동기화 걸어버림
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
