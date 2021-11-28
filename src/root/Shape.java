package root;

/**
 * The abstract scelleton class for any drawable shape.
 * {@link #draw()} and {@link #rotate()} must be implemented.
 *
 * Constructor are protected because abstract classes are not instantiable, so they dont need to be public.
 *
 * @author Christopher Hübner
 * @version 1.0.0
 */
public abstract class Shape {

    /**
     * The foreground character.
     */
    protected char foreground = '+';

    /**
     * The background character.
     */
    protected char background = '-';

    /**
     * Any shape has a base width. For example a circle has a diameter. Other shapes may implement other
     * widths or heights. But thi shape is considered to be the highest length within any shape.
     * The tota length of a shape shall be the base with, plus the margin on each side.
     */
    protected int baseWidth;

    /**
     * The margin for left and right side. Total margin shalle be {@link #margin} * 2.
     */
    protected int margin = 0;

    /**
     * A boolean that indicates whether the shape is turned.
     * The standard is set to false.
     */
    protected boolean turned = false;

    /**
     * A constructor that sets any fields.
     *
     * @param baseWidth  The base width.
     * @param foreground The foregorund character.
     * @param background The background character.
     * @param margin     The margin for each side.
     * @param rotated    Indicates whether this shape should be rotaded.
     */
    protected Shape(int baseWidth, char foreground, char background, int margin, boolean rotated) {
        this.baseWidth = baseWidth;
        this.foreground = foreground;
        this.background = background;
        this.margin = margin;
        this.turned = rotated;
    }

    /**
     * A constructor that sets the parameter given fields.
     *
     * @param baseWidth  The base width.
     * @param foreground The foregorund character.
     * @param background The background character.
     * @param margin     The margin for each side.
     */
    protected Shape(int baseWidth, char foreground, char background, int margin) {
        this.baseWidth = baseWidth;
        this.foreground = foreground;
        this.background = background;
        this.margin = margin;
    }

    /**
     * A constructor that sets the parameter given fields.
     *
     * @param baseWidth The base width.
     * @param margin    The margin for each side.
     */
    protected Shape(int baseWidth, int margin) {
        this.baseWidth = baseWidth;
        this.margin = margin;
    }

    /**
     * A constructor that sets the parameter given fields.
     *
     * @param baseWidth The base width.
     */
    protected Shape(int baseWidth) {
        this.baseWidth = baseWidth;
    }

    /**
     * Indicates whether the shape is turned.
     *
     * @return Returns {@link #turned}
     */
    public boolean isTurned() {
        return turned;
    }

    /**
     * A abstract method to be implemented by inheriting classes.
     * Draw draws the actual shape. Its abstract due polymorphy usecases.
     */
    public abstract void draw();

    /**
     * A abstract method to be implemented by inheriting classes.
     * Rotate rotates the actual shape. Its abstract due polymorphy usecases.
     */
    public abstract void rotate();
}