public class Circle {
    int radius;     // 원의 반지름 필드
    String name;    // 원의 이름 필드

    public Circle() { }    // 원의 생성자

    public double getArea() {   // 원의 면적 계산 메소드
        return 3.14 * this.radius * this.radius;
    }

    public void printName() {
        System.out.println(this.name + "의 면적은 " + getArea() + "입니다.");
    }

    public static void main(String[] args) throws Exception {
        Circle pizza;
        pizza = new Circle();   // Circle 객체 생성
        pizza.radius = 10;      // 피자의 반지름을 10으로 설정
        pizza.name = "자바피자";    // 피자의 이름 설정
        pizza.printName();

        Circle donut = new Circle();    // Circle 객체 생성
        donut.radius = 2;           // 도넛의 반지름을 2로 설정
        donut.name = "자바도넛";      // 도넛의 이름 설정
        donut.printName();

    }
}
