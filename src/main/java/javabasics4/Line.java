package javabasics4;

public class Line {

    private final double x0;
    private final double y0;
    private final double x1;
    private final double y1;

    public Line(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public double getSlope() {
        if (x1 == x0) {
            throw new ArithmeticException("x1 cannot equal x0");
        }
        return (y1 - y0) / (x1 - x0);
    }

    public double getDistance() {
        return Math.sqrt(Math.pow((x1 - x0), 2) + Math.pow((y1 - y0), 2));
    }

    public boolean parallelTo(Line other) {
        final double threshold = 0.0001;
        return Math.abs(this.getSlope() - other.getSlope()) < threshold;
    }
}
