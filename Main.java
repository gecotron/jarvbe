public class Main {

}

class Rectangle {
    private int left;
    private int bottom;
    private int height;
    private int width;

    public Rectangle() {
        left = 0;
        bottom = 0;
        height = 0;
        width = 0;
    }

    public Rectangle(int l, int b, int h, int w) {
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

    public void set(int l, int b, int h, int w) {
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

    public String printString() {
        return "Base: (" + left + ", " + bottom + ") w: " + width + " h: " + height;
    }

    public int area() {
        return (height * width);
    }

    public int perimetre() {
        return (height * 2) + (width * 2);
    }

    public boolean contains(Rectangle rect) {
        boolean contained;
        if (rect.left >= this.left && rect.bottom >= this.bottom) {
            if (rect.height >= this.height && rect.width >= this.width) {
                contained = true;
            } else
                contained = false;
        } else
            contained = false;

        return contained;
    }

    public boolean intersect(Rectangle rect) {
        boolean intersects = false;
        int right = this.left+this.width;
        int top = this.bottom+this.height;
        return intersects;
    }

    public static int totalPerimetre(Rectangle rectA, Rectangle rectB) {
        int total = 0;
        if (!rectA.contains(rectB) && rectA.intersect(rectB)) {

        } else if (rectA.contains(rectB)) {
            total = rectA.perimetre();
        } else {
            total = rectA.perimetre() + rectB.perimetre();
        }
        return total;
    }
}