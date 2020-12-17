package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.List;

public class Triangle extends Obstacle {
    public Group myTriangle;

    public Triangle(Group myTriangle,double x,double y,ImageView star,Circle colorSwitch) {
        super(x,y,star,colorSwitch);
        this.myTriangle = myTriangle;

    }

    @Override
    public void rotateMe(Group g,boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), this.myTriangle);
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

        this.myTriangle.setLayoutX(x);
        this.myTriangle.setLayoutY(y);
        this.star.setLayoutY(this.Ylayout-20);
        this.star.setLayoutX(this.Xlayout-20);
        this.colorSwitch.setLayoutY(this.Ylayout+170);
        this.colorSwitch.setLayoutX(this.Xlayout);
    }
    @Override
    public void updateMyPosition(Pane p, List<Obstacle> myList, Obstacle o, int index,Group g) {
        //p.getChildren().remove(g);
        myList.remove(index);
        o.arrangeMe(500,-765);
        //g.setLayoutY(-1665);
        //p.getChildren().add(((Triangle) o).myTriangle);
        ((Triangle) o).myTriangle.setVisible(true);
        myList.add(o);
        System.out.println("I was added successfully --triangle");
 ///

    }

    @Override
    public boolean checkCollision(Obstacle obj, Circle ball) {
        for (Node path:((Triangle) obj).myTriangle.getChildren()){
            if(((Path)(javafx.scene.shape.Shape.intersect(ball,(javafx.scene.shape.Shape)path))).getElements().size()>0){
                System.out.println("Yessssssssssssssssssss toued triangle");
                System.out.println(ball.getFill());
                System.out.println(((Shape) path).getStroke());
                if(!((Shape) path).getStroke().toString().equals(ball.getFill().toString())){
                    System.out.println(" ----------------------off different color --traingle");
                    return true;
                }
            }
        }
        return false;
    }
}
