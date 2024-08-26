package lessonthreeshape;

public class Rectangle extends Shape {
    int a, b;

    public Rectangle(int x, int y, int a, int b, String name) {
        super(x, y, name);
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return super.toString() + ", a=" + a +
                ", b=" + b;
    }
}
