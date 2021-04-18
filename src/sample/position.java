package sample;

public class position {
    private double x;
    private double y;
    private double z;




    public position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public double getZ() {
        return z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
