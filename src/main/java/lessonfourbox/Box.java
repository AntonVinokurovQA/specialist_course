package lessonfourbox;

import java.util.Comparator;

public class Box implements Comparable<Box> {
    int a, b, c;

    public Box(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /* Local anonymous class example */
    public static Comparator<Box> compareByA() {
        return new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return box1.getA() - box2.getA();
            }
        };
    }

    public int getValue() {
        return a * b * c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Box{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
    /* Inner class example */
//    public class CompareByA implements Comparator<Box> {
//        @Override
//        public int compare(Box box1, Box box2) {
//            return box1.getA() - box2.getA();
//        }
//    }

    /* Inner static class example */
//    public static class CompareByA implements Comparator<Box> {
//        @Override
//        public int compare(Box box1, Box box2) {
//            return box1.getA() - box2.getA();
//        }
//    }

    @Override
    public int compareTo(Box o) {
        return this.getValue() - o.getValue();
    }
}