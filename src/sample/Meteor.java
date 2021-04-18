package sample;


import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;

public class Meteor extends position{
    private double radius;
    private Sphere grafika;




    public Meteor(double x, double y, double z, double radius) {
        super(x, y, z);
        this.radius = radius;
        grafika= new Sphere(radius);
        grafika.translateXProperty().set(x);
        grafika.translateYProperty().set(y);
        grafika.translateZProperty().set(z);



    }

    public Sphere getGrafika() {
        return grafika;
    }

}
