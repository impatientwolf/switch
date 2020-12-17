package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.List;

public class Star extends Obstacle{

    public ImageView star;

    public Star(double xlayout, double ylayout, ImageView star) {
        super(xlayout, ylayout);
        this.star = star;
    }

    @Override
    public void rotateMe(Group g, boolean reverse, int angle, int duration) {

    }

    @Override
    public void arrangeMe(double x, double y) {

    }

    @Override
    public void updateMyPosition(Pane p, List<Obstacle> myList, Obstacle o, int index, Group g) {

    }

    @Override
    public boolean checkCollision(Obstacle obj, Circle ball) {
        return false;
    }
}
