package singleton;

public class LazyInitialization {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    private static LazyInitialization instance;

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private LazyInitialization() {
    }

    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
