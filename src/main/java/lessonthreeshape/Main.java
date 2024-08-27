package lessonthreeshape;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1,2,  3, "circle-1");
        Rectangle rectangle = new Rectangle(1,2, 3,4, "rectangle-1");

        Shape[] o = new Shape[] {
                circle,
                rectangle,
                new Circle(1,2,  3, "circle-2"),
                new Rectangle(1,2, 3,4, "rectangle-2")
        };

        for(Shape shape: o){
            System.out.println(shape.area());
        }
    }
}
