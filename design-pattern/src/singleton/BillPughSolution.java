package singleton;

public class BillPughSolution {
    private BillPughSolution() {
    }

    // static 내부 클래스를 이용
    // Holder로 만들어, 클래스가 메모리에 로드되지 않고 getInstance 메소드가 호출되어야 로드됨
    public static BillPughSolution getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    private static class SingleInstanceHolder {
        private static final BillPughSolution INSTANCE = new BillPughSolution();
    }
}
