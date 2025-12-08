class Pair {
    Point3D pointA;
    Point3D pointB;
    double distance;

    public Pair(Point3D pointA, Point3D pointB, double distance) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.distance = distance;
    }
    
    public Point3D getPointA() {
        return pointA;
    }

    public Point3D getPointB() {
        return pointB;
    }

    public double getDistance() {
        return distance;
    }

    public String toString() {
        return "Pair{" +
                "pointA x=" + pointA.getX() +
                ", pointB x=" + pointB.getX() +
                ", distance=" + distance +
                '}';
    }

}