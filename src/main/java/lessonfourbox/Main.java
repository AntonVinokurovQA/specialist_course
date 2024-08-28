package lessonfourbox;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box[] boxes = new Box[]{
                new Box(10, 1, 1),
                new Box(1, 10, 10),
                new Box(2, 2, 2)
        };

        Arrays.sort(boxes);

        for (Box box : boxes) {
            System.out.println(box);
        }
/*      При момощи внутреннего класса реализующего интерфейс Comparator
        Box.CompareByA compareByA = new Box(0, 0, 0).new CompareByA();
        Arrays.sort(boxes, compareByA); */

/*      При момощи внутреннего статического класса реализующего интерфейс Comparator
        Arrays.sort(boxes, new Box.CompareByA());*/

/*      При помощи локального анонимного класса в методе compareByA()
        Arrays.sort(boxes, Box.compareByA());*/

        /*      При помощи анонимного класса в аргументе
        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return box1.getA()-box2.getA();
            }
        });*/

/*      При помощи лямд
        Arrays.sort(boxes, (box1, box2) -> box1.getA()-box2.getA()); */

        for (Box box : boxes) {
            System.out.println(box);
        }
    }
}
