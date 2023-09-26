package singleton;

public class EagerInitialization {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    private static final EagerInitialization INSTANCE = new EagerInitialization();

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private EagerInitialization() {
    }

    public static EagerInitialization getInstance() {
        return INSTANCE;
    }
}
