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

    public Rectangle(int l, int b, int w, int h) {
        this.set(l, b, w, h);
    }

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

    public int area() {
        return (height * width);
    }

    public int perimeter() {
        if (width == 0) {
            return height;
        } else if (height == 0) {
            return width;
        } else if (width == 0 && height == 0) {
            return 0;
        } else {
            return 2 * (height + width);
        }
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
        return this.left < rect.left + rect.width && this.left + this.width > rect.left
                && this.bottom < rect.bottom + rect.height && this.bottom + this.height > rect.bottom;

    }

    public static Rectangle intersection(Rectangle rectA, Rectangle rectB) {
        return new Rectangle(Math.max(rectA.left, rectB.left), Math.max(rectA.bottom, rectB.bottom),
                (Math.min(rectA.left + rectA.width, rectB.left + rectB.width) - Math.max(rectA.left, rectB.left)),
                (Math.min(rectA.bottom + rectA.height, rectB.bottom + rectB.height) - Math.max(rectA.bottom, rectB.bottom)));
    }

    public static int totalperimeter(Rectangle rectA, Rectangle rectB) {
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