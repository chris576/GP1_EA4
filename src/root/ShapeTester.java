package root;

import java.util.List;

/**
 * A class to test whether the Shapes do draw correctly.
 *
 * @author Christopher Hübner
 * @version 1.0.0
 */
public class ShapeTester {

    /**
     * The entry point within this application.
     *
     * @param args The optional arguments.
     */
    public static void main(String[] args) {
        List<Shape> list = List.of(
                new Trapezium(13, 5, '*', '/', 2),
                new Triangle(17, 'F', 'b', 4, true),
                new Rhombus(13, 'W', 'b', 6),
                new NordmannFir(17, '*', '-', 2),
                new NordmannFir(19, '~', '#', 4, true));
        list.forEach(Shape::draw);
    }
}
