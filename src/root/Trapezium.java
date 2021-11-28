package root;

/**
 * A class to display a trapezium on the console.
 *
 * @author Christopher
 * @version 1.0.0
 */
public class Trapezium extends Shape {

    /**
     * The bottom width.
     */
    private int bottomWidth;

    /**
     * The constructor for a trapezium.
     *
     * @param topWidth    The top width.
     * @param bottomWidth The bottom width.
     * @param foreground  The foreground character.
     * @param background  The background character.
     * @param margin      The margin.
     * @param rotated     The boolean that indicates whether it should be rotated.
     */
    public Trapezium(int topWidth, int bottomWidth, char foreground, char background, int margin, boolean rotated) {
        super(topWidth, foreground, background, margin, rotated);
        this.bottomWidth = bottomWidth;
    }

    /**
     * The constructor for a trapezium.
     *
     * @param topWidth    The top width.
     * @param bottomWidth The bottom width.
     * @param foreground  The foreground character.
     * @param background  The background character.
     * @param margin      The margin.
     */
    public Trapezium(int topWidth, int bottomWidth, char foreground, char background, int margin) {
        super(topWidth, foreground, background, margin);
        this.bottomWidth = bottomWidth;
    }

    /**
     * The constructor for a trapezium.
     *
     * @param topWidth    The top width.
     * @param bottomWidth The bottom width.
     * @param margin      The margin.
     */
    public Trapezium(int topWidth, int bottomWidth, int margin) {
        super(topWidth, margin);
        this.bottomWidth = bottomWidth;
    }

    /**
     * The constructor for a trapezium.
     *
     * @param topWidth    The top width.
     * @param bottomWidth The bottom width.
     */
    public Trapezium(int topWidth, int bottomWidth) {
        super(topWidth);
        this.bottomWidth = bottomWidth;
    }

    /**
     * Draws the actual trapezium.
     */
    @Override
    public void draw() {
        // Der Boolean wird verwendet um darzustellen, ob die größere Seite obe auf dem Trapez ist, oder nicht.
        final boolean topBaseIsSmaller = baseWidth <= bottomWidth;
        // C steht für current und ist eine variable die sich beim Berechnungsprozess verändert. Unverändert ist
        // es die Margin und shape länge der ersten Zeile. Abhängig von topBaseIsSmaller wird es dann erhöht, oder
        // verringert.
        int cShapeLength = baseWidth;
        int cMargin = topBaseIsSmaller ?
                margin + ((bottomWidth - baseWidth) / 2) : margin;
        // Größte Seite des Trapez plus Margin
        int totalLength = Math.max(baseWidth, bottomWidth) + (margin * 2);
        if (topBaseIsSmaller)
            paintUp(totalLength, cShapeLength, cMargin);
        else
            paintDown(totalLength, cShapeLength, cMargin);
    }

    /**
     * Paint up is used when the upper width is smaller than the lower. In this case per line the shape width must
     * be increased and the margin width decreased until the width of the lower side is drawed.
     *
     * @param totalLength  The total length of the drawing. Incl margin AND shape width.
     * @param cShapeLength The length of the shape in the first line.
     * @param cMargin      The margin of the shape in the first line.
     */
    private void paintUp(int totalLength, int cShapeLength, int cMargin) {
        int marginLeft = cMargin;
        int marginRight = cMargin;
        while (cShapeLength <= bottomWidth) {
            StringBuffer buffer = new StringBuffer();
            for (int e = 0; e != totalLength; e++) {
                if (e >= marginLeft && e < cShapeLength + marginRight) {
                    buffer.append(foreground);
                } else {
                    buffer.append(background);
                }
            }
            buffer.append("\n");
            System.out.print(buffer.toString());
            marginLeft--;
            marginRight--;
            cShapeLength = cShapeLength + 2;
        }
    }

    /**
     * Paint down is used when the upper width is grater than the lower. In this case per line the shape width must
     * be decreased and the margin width increased until the width of the lower side is drawed.
     *
     * @param totalLength  The total length of the drawing. Incl margin AND shape width.
     * @param cShapeLength The length of the shape in the first line.
     * @param cMargin      The margin of the shape in the first line.
     */
    private void paintDown(int totalLength, int cShapeLength, int cMargin) {
        int marginLeft = cMargin;
        int marginRight = cMargin;
        while (cShapeLength >= bottomWidth) {
            StringBuffer buffer = new StringBuffer();
            for (int e = 0; e != totalLength; e++) {
                if (e >= marginLeft && e < cShapeLength + marginRight) {
                    buffer.append(foreground);
                } else {
                    buffer.append(background);
                }
            }
            buffer.append("\n");
            System.out.print(buffer.toString());
            marginLeft++;
            marginRight++;
            cShapeLength = cShapeLength - 2;
        }
    }

    /**
     * Rotates by swaping top with bottom width.
     */
    @Override
    public void rotate() {
        int tmpTopWidth = baseWidth;
        int tmpBottomWidth = bottomWidth;
        this.baseWidth = tmpBottomWidth;
        this.bottomWidth = tmpTopWidth;
        turned = !turned;
    }
}
