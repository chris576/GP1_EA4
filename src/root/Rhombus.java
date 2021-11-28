package root;

import java.util.Arrays;

/**
 * A class to display a werder rhombus on the console.
 *
 * @version 1.0.0
 * @author Christopher Hübner
 */
public class Rhombus extends Shape {

    /**
     * The two triangles the rhombus is made of.
     */
    protected Triangle[] triangles = new Triangle[2];

    /**
     * The constructor of a rhombus.
     * @param baseWidth The width.
     * @param foreground The foreground.
     * @param background The background.
     * @param margin The margin on each side.
     */
    public Rhombus(int baseWidth, char foreground, char background, int margin) {
        super(baseWidth, foreground, background, margin);
        setTriangles();
    }

    /**
     * The constructor of a rhombus.
     * @param baseWidth The width.
     * @param margin The margin on each side.
     */
    public Rhombus(int baseWidth, int margin) {
        super(baseWidth, margin);
        setTriangles();
    }

    /**
     * The constructor of a rhombus.
     * @param baseWidth width.
     */
    public Rhombus(int baseWidth) {
        super(baseWidth);
        setTriangles();
    }

    /**
     * Instanziates the triangles.
     */
    private void setTriangles () {
        triangles[0] = new Triangle(baseWidth, foreground, background, margin);
        triangles[1] = new Triangle(baseWidth, foreground, background, margin, true);
    }

    /**
     * Draws the actual rhombus.
     */
    @Override
    public void draw() {
        Arrays.stream(triangles).forEach(Triangle::draw);
    }

    /**
     * A rhombus rotated is rhombus ... ;)
     */
    @Override
    public void rotate() {
        turned = !turned;
        //A Rhombus rotated is rhombus ...
    }
}
