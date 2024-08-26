package lessonthreeshape;

public class Shape {
    private int x, y;
    private String name;

    public Shape(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", x=" + x +
                ", y=" + y;
    }
}
