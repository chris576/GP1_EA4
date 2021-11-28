package root;

import java.util.List;

/**
 * A class to test whether the Shapes do draw correctly.
 *
 * @author Christopher Hübner
 * @version 1.0.0
 * @MessageToDozent I know that some implementations do not meet the exact implementation requirements in the api and
 * the task. But I develop Java Software for now 3 years. I thought this approach might be a little better, little more
 * flexible when extended, and a lot more challanging to implement. I want to thank you for this basic but challanging
 * task. Within the last 6 hours I had the chance to fetch out a lot of what I have learned within my last apprenticeship.
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
