class Rectangle {
    Point2D pointA;
    Point2D pointB;
    long size;

    public Rectangle(Point2D pointA, Point2D pointB, long size) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.size = size;
    }
    
    public Point2D getPointA() {
        return pointA;
    }

    public Point2D getPointB() {
        return pointB;
    }

    public long getSize() {
        return size;
    }

    public String toString() {
        return "Rectangle{" +
                "pointA x=" + pointA.getX() +
                ", pointB x=" + pointB.getX() +
                ", size=" + size +
                '}';
    }

}