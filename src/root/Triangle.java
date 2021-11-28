package root;

/**
 * The class to ecapsluates a drawable Triangle.
 *
 * @version 1.0.0
 * @author Christopher Hübner
 */
public class Triangle extends Shape {

    /**
     * The constructor for a triangle.
     * @param baseWidth The base width.
     * @param foreground The foreground character.
     * @param background The background character.
     * @param margin The margin.
     * @param rotated Indicates whether the triangle is up side down.
     */
    public Triangle(int baseWidth, char foreground, char background, int margin, boolean rotated) {
        super(baseWidth, foreground, background, margin, rotated);
    }

    /**
     * The constructor for a triangle.
     * @param baseWidth The base width.
     * @param foreground The foreground character.
     * @param background The background character.
     * @param margin The margin.
     */
    public Triangle(int baseWidth, char foreground, char background, int margin) {
        super(baseWidth, foreground, background, margin);
    }

    /**
     * The constructor for a triangle.
     * @param baseWidth The base width.
     * @param margin The margin.
     */
    public Triangle(int baseWidth, int margin) {
        super(baseWidth, margin);
    }

    /**
     * The constructor for a triangle.
     * @param baseWidth The base width.
     */
    public Triangle(int baseWidth) {
        super(baseWidth);
    }

    /**
     * Draws the actual triangle.
     */
    @Override
    public void draw() {
        // C steht für current und ist eine variable die sich beim Berechnungsprozess verändert. Unverändert ist
        // es die Margin und shape länge der ersten Zeile. Abhängig von topBaseIsSmaller wird es dann erhöht, oder
        // verringert.
        int cShapeLength = turned ? baseWidth : 1;
        int cMargin = turned ? margin: margin + ((baseWidth) / 2);
        // Größte Seite des Trapez plus Margin
        int totalLength = (baseWidth - 1) + (margin * 2);
        if (turned)
            paintDown(totalLength, cShapeLength, cMargin);
        else
            paintUp(totalLength, cShapeLength, cMargin);
    }

    /**
     * If the triangle is NOT upside down the top is ontop, so the length of the shape must be increased and the
     * margin descreased per line, until the margin is the {@link #margin} and the cShapeLength is {@link #baseWidth}.
     * @param totalLength Margin on both sides plus the shape length.
     * @param cShapeLength The shape length on the first line.
     * @param cMargin The margin per side on the first line.
     */
    private void paintUp(int totalLength, int cShapeLength, int cMargin) {
        int marginLeft = cMargin;
        int marginRight = cMargin;
        while (cShapeLength <= baseWidth) {
            StringBuffer buffer = new StringBuffer();
            for (int e = 0; e <= totalLength; e++) {
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
     * If the triangle is upside down the top is on bottom, so the length of the shape must be decreased and the
     * margin increased per line until cShapeLength is 1.
     * @param totalLength Margin on both sides plus the shape length.
     * @param cShapeLength The shape length on the first line.
     * @param cMargin The margin per side on the first line.
     */
    private void paintDown(int totalLength, int cShapeLength, int cMargin) {
        int marginLeft = cMargin;
        int marginRight = cMargin;
        while (cShapeLength >= 1) {
            StringBuffer buffer = new StringBuffer();
            for (int e = 0; e <= totalLength; e++) {
                if (e >= marginLeft && e <= cShapeLength + marginRight - 1) {
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
     * Sets the alien landing station (pyramid) upside down.
     */
    @Override
    public void rotate() {
        turned = !turned;
    }
}