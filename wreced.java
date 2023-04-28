public class wreced {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(-7, 0, 6, 5);
        Rectangle r2 = new Rectangle(-1, 0, 6, 4);
        System.out.println(Rectangle.intersection(r1, r2).toString());
    }
}

class Rectangle {
    private int left;
    private int bottom;
    private int height;
    private int width;
    // Base initialise
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

    public String toString() {
        return "base: (" + left + "," + bottom + ") w:" + width + " h:" + height;
    }
    // return the area of the rectangle
    public int area() {
        return (height * width);
    }
    // Return Perimeter of the rectangle
    public int perimeter() {
        if (width == 0) {
            return height;
        } else if (height == 0) {
            return width;
        } else {
            return 2 * (height + width);
        }
    }
    // Check if the rectangle contains another rectangle
    public boolean contains(Rectangle rect) {
        if (rect.left >= this.left && rect.bottom >= this.bottom && (rect.left + rect.width) <= (this.left + this.width) &&  (rect.bottom + rect.height) <= (this.bottom + this.height)) {
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
    // create a new rectangle based on the intersection of 2 rectangles
    public static Rectangle intersection(Rectangle rectA, Rectangle rectB) {
        if (rectA.intersect(rectB) && rectB.intersect(rectA)) {
            return new Rectangle(Math.max(rectA.left, rectB.left), Math.max(rectA.bottom, rectB.bottom),
                (Math.min(rectA.left + rectA.width, rectB.left + rectB.width) - Math.max(rectA.left, rectB.left)),
                (Math.min(rectA.bottom + rectA.height, rectB.bottom + rectB.height) - Math.max(rectA.bottom, rectB.bottom)));
        }
        else {
            return new Rectangle();
        }
    }
    // Get total perimetre of 2 rectangles
    public static int totalPerimeter(Rectangle rectA, Rectangle rectB) {
        if (!rectA.contains(rectB) && rectA.intersect(rectB)) {
            Rectangle rectC = intersection(rectA, rectB);
            return (rectA.height + rectB.height - rectC.height) * 2 + (rectA.width + rectB.width - rectC.width) * 2;
        } else if (rectA.contains(rectB)) {
            return rectA.perimeter();
        } else {
            return rectA.perimeter() + rectB.perimeter();
        }
    }
}