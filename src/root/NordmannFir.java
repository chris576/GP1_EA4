package root;

import java.util.LinkedList;

/**
 * This class encapsulates a drawable nordmann fir (XMasTree).
 *
 * @author Christopher Hübner
 * @version 1.0.0
 */
public class NordmannFir extends Shape {

    /**
     * The constructor for a normann fir.
     *
     * @param width      The bottom width of the fir.
     * @param foreground The foreground character.
     * @param background The background character.
     * @param margin     The margin of the bottom width.
     * @param rotated    Should the nordman fir be painted upside down?
     */
    protected NordmannFir(int width, char foreground, char background, int margin, boolean rotated) {
        super(width, foreground, background, margin, rotated);
    }

    /**
     * The constrcutor of the nordmann fir.
     *
     * @param width      The bottom width of the fir.
     * @param foreground The foreground character.
     * @param background The background character.
     * @param margin     The margin of the bottom width.
     */
    protected NordmannFir(int width, char foreground, char background, int margin) {
        super(width, foreground, background, margin);
    }

    /**
     * The constructor of the normann fir.
     *
     * @param width  The bottom width of the fir.
     * @param margin The margin of the bottom width.
     */
    protected NordmannFir(int width, int margin) {
        super(width, margin);
    }

    /**
     * The constructor of the nordmann fir.
     *
     * @param width The width of the nordmann fir.
     */
    protected NordmannFir(int width) {
        super(width);
    }

    /**
     * The Nordmannfir is calculated from bottom side up. The largest element is calculated first, the smallest at last.
     * If the fir is rotated, the elemens should be drawn from greatest to smallest. If not, from smallest to greatest.
     * Therefore I used a {@link LinkedList}. It provides the possibility to add a element to the first index, or the
     * last. If the nordmann fir is not rotated, an trapezium and triangle is added to the first index. If it is, its
     * placed to the last index.
     *
     * @return Retruns a linked list with the nordmannfirs shapes.
     */
    private LinkedList<Shape> calculateFir() {
        LinkedList<Shape> shapes = new LinkedList<>();
        final int totalLength = margin * 2 + baseWidth;
        NordmannFirTrapeziumModel componentModel = new NordmannFirTrapeziumModel(baseWidth, baseWidth - 8, margin);
        do {
            Trapezium trapezium = new Trapezium(
                    componentModel.topWidth, componentModel.bottonWidth, foreground, background, componentModel.margin);
            addShapeToList(trapezium, shapes);
            componentModel = calculateTrapezium(componentModel, totalLength);
        } while (componentModel.topWidth >= 3);
        //Calculate the top of the fir.
        int topBaseWidth = componentModel.topWidth + 4;
        Triangle triangle = new Triangle(topBaseWidth, foreground, background, (totalLength - topBaseWidth) / 2);
        addShapeToList(triangle, shapes);
        return shapes;
    }

    /**
     * To prevent from code duplication and respect the DRY rule, this methods only purpose is to bring a shape and a
     * list in the correct order together.
     *
     * "What is my purpose? You bring the butter".
     *
     * @param shape The shape to add.
     * @param list  The List to be added.
     */
    private void addShapeToList(Shape shape, LinkedList<Shape> list) {
        if (turned) {
            shape.rotate();
            list.addLast(shape);
        } else {
            list.addFirst(shape);
        }
    }

    /**
     * Calculates the next trapezium of the fir according to the given model. Due the fir is calculated downside up,
     * this method calculates the next smaller trapezium of the fir.
     * <p>
     * I had many troubles with the algorithm of calculating the nirs elements. Therefore I created this method to
     * encapsulate the calculating process of the next element within a own method.
     *
     * @param model The component of which the next firs trapezium should be calculated.
     * @return Returns the next trapezium as a model instance.
     */
    private NordmannFirTrapeziumModel calculateTrapezium(NordmannFirTrapeziumModel model, int totalLength) {
        int newBotton = model.topWidth + 6;
        int newTop = newBotton - 8;
        int new_margin = (totalLength - newBotton) / 2;
        return new NordmannFirTrapeziumModel(newBotton, newTop, new_margin);
    }

    /**
     * Draws the actual shape. Each Nordmann Fir component is calculated before drawing them.
     */
    @Override
    public void draw() {
        calculateFir().forEach(Shape::draw);
    }

    /**
     * Rotates the fir by changing a flag. Turned becomes not turned.
     */
    @Override
    public void rotate() {
        turned = !turned;
    }

    /**
     * This is a private inner class that is used to encapsulate the model for a trapezium within the nordman fir.
     * Its only used to make it easier to calculate the next trapezium within the fir.
     * <p>
     * I had many problems with my algorithm of calculating the firs elements. Therefore I created this helper class,
     * thats purpose was to encapsulate the model of a trapezium within the fir.
     *
     * @author Christopher Hübner
     * @version 1.0.0
     */
    private class NordmannFirTrapeziumModel {

        /**
         * The botom width of the trapezium.
         */
        public final int bottonWidth;

        /**
         * The top width of the trapezium.
         */
        public final int topWidth;

        /**
         * The margin of the trapezium.
         */
        private final int margin;

        /**
         * This is the constructor for a NordmannFirTrapeziumModel.
         *
         * @param bottonWidth The botton width of the trapezium.
         * @param topWidth    The top width of the trapezium.
         * @param margin      The margin of the trapezium.
         */
        public NordmannFirTrapeziumModel(int bottonWidth, int topWidth, int margin) {
            this.bottonWidth = bottonWidth;
            this.topWidth = topWidth;
            this.margin = margin;
        }
    }
}
