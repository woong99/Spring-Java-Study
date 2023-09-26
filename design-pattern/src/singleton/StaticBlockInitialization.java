package singleton;

public class StaticBlockInitialization {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    private static StaticBlockInitialization instance;

    // static 블록을 이용해 예외 처리
    static {
        try {
            instance = new StaticBlockInitialization();
        } catch (Exception e) {
            throw new RuntimeException("싱글톤 객체 생성 오류");
        }
    }

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private StaticBlockInitialization() {
    }

    public static StaticBlockInitialization getInstance() {
        return instance;
    }
}
