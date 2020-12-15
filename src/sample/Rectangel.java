package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.List;

public class Rectangel extends Obstacle {
    public Group myRectangle;

    public Rectangel(Group myRectangle,double x,double y) {
        super(x,y);
        this.myRectangle= myRectangle;
    }

    @Override
    public void rotateMe(Group g,boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), this.myRectangle);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(2);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }

    @Override
    public void arrangeMe(double x,double y) {
        this.Xlayout=x;
        this.Ylayout=y;
        this.myRectangle.setLayoutY(y);
        this.myRectangle.setLayoutX(x);
    }
    @Override
    public void updateMyPosition(Pane p, List<Obstacle> myList, Obstacle o, int index,Group g) {
        p.getChildren().remove(g);
        myList.remove(index);
        o.arrangeMe(500,-765);
        //g.setLayoutY(-1665);
        p.getChildren().add(((Rectangel) o).myRectangle);
        ((Rectangel) o).myRectangle.setVisible(true);
        myList.add(o);
    }
}
