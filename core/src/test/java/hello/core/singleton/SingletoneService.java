package hello.core.singleton;

public class SingletoneService {

    // 클래스 변수 선언으로 인스턴스 만들기 전에 미리 만들어진다 -> 모든 인스턴스가 공유함 (해당 클래스의)
    private static final SingletoneService instance = new SingletoneService();

    // getInstance를 통해 미리 만든 인스턴스를 제공한다
    public static SingletoneService getInstance() {
        return instance;
    }

    // private로 설정해서 외부에서 new로 새로운 객체 만들기 방지 -> 생성자를 막아줌 -> 매우 중요하다
    private SingletoneService() {
    }

    public void logic() {
        System.out.println("싱글통 객체 로직 호출");
    }


}
