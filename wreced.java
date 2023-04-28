class Rectangle {
    private int left;
    private int bottom;
    private int height;
    private int width;
    // Base initialisation
    public Rectangle() {
        left = 0;
        bottom = 0;
        height = 0;
        width = 0;
    }
    // Basic constructor
    public Rectangle(int l, int b, int w, int h) {
        this.set(l, b, w, h);
    }
    // Set Rectangle values
    public void set(int l, int b, int w, int h) {
        left = l;
        bottom = b;
        if (h < 0)
            height = 0;
        else
            height = h;
        if (w < 0)
            width = 0;
        else
            width = w;
    }
    // Prints readable output of rectangle
    public String toString() {
        return "base: (" + left + "," + bottom + ") w:" + width + " h:" + height;
    }

    // return the area of the rectangle
    public int area() {
        return (height * width);
    }
    // Return Perimeter of the rectangle
    public int perimeter() {
        // Check if the rectangle is just a line
        if (width == 0) {
            return height;
        } else if (height == 0) {
            return width;
        }
        // Otherwise return normal perimetre
        else {
            return 2 * (height + width);
        }
    }
    // Check the type of perimetre a rectangle has
    public char perimType() {
        // Check if the rectangle is just a line
        if (width == 0) {
            return 'l';
        } else if (height == 0) {
            return 'l';
        }
        // Otherwise return normal rectangle
        else {
            return 'r';
        }
    }
    // Check if the rectangle contains another rectangle
    public boolean contains(Rectangle rect) {
        if (rect.left >= this.left && rect.bottom >= this.bottom && (rect.left + rect.width) <= (this.left + this.width)
                && (rect.bottom + rect.height) <= (this.bottom + this.height)) {
            return true;
        } else {
            return false;
        }
    }
    // Check if a rectangle intersects with another rectangle
    public boolean intersect(Rectangle rect) {
        return this.left <= rect.left + rect.width && this.left + this.width >= rect.left
                && this.bottom <= rect.bottom + rect.height && this.bottom + this.height >= rect.bottom;
    }
    // Create a new rectangle based on the intersection of 2 rectangles
    public static Rectangle intersection(Rectangle rectA, Rectangle rectB) {
        // Checks if the rectangles actually intersect
        if (rectA.intersect(rectB) && rectB.intersect(rectA)) {
            // Builds Rectangle
            return new Rectangle(Math.max(rectA.left, rectB.left), Math.max(rectA.bottom, rectB.bottom),
                    (Math.min(rectA.left + rectA.width, rectB.left + rectB.width) - Math.max(rectA.left, rectB.left)),
                    (Math.min(rectA.bottom + rectA.height, rectB.bottom + rectB.height)
                            - Math.max(rectA.bottom, rectB.bottom)));
        } else {
            // Returns empty rectangle if the given rectangles don't intersect
            return new Rectangle();
        }
    }
    // Get total perimetre of 2 rectangles
    public static int totalPerimeter(Rectangle rectA, Rectangle rectB) {
        // Check if the rectangles intersect, and that one reactangle doesn't contain the other
        if (!rectA.contains(rectB) && rectA.intersect(rectB) || !rectB.contains(rectA) && rectB.intersect(rectA)) {
            // Build new rectangle based on intersection
            Rectangle rectC = intersection(rectA, rectB);
            // Gets total perimetre of the two rectangles, accounting for the intersected space
            // Check if the intersected space is a line
            if (rectC.perimType() == 'l') {
                return rectA.perimeter() + rectB.perimeter() - (rectC.perimeter()*2);
            } else {
            return rectA.perimeter() + rectB.perimeter() - rectC.perimeter();
            }
        } 
        // If rectangle contains other rectangle, return containing rectangles perimetre
        else if (rectA.contains(rectB)) {
            return rectA.perimeter();
        } else if (rectB.contains(rectA)) {
            return rectB.perimeter();
        }
        // All else fails, return the two perimetres added together
         else {
            return rectA.perimeter() + rectB.perimeter();
        }
    }
}