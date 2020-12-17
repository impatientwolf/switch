package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.util.List;

public class DoubleCircle extends Obstacle{
public Group leftCircle;
public double x1;
public double y1;
public Group rightCircle;
public double x2;
public double y2;

    public DoubleCircle(Group leftCircle, double x1, double y1, Group rightCircle, double x2, double y2, ImageView star,Circle colorSwitch) {
        super(x1,y1,null,colorSwitch);
        this.leftCircle = leftCircle;
        this.x1 = x1;
        this.y1 = y1;
        this.rightCircle = rightCircle;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void rotateMe(Group g,boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), this.leftCircle);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(2);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
        // do opposite of left
        RotateTransition rotateTransition2 = new RotateTransition(Duration.seconds(duration), this.rightCircle);
        rotateTransition2.setAutoReverse(reverse);
        rotateTransition2.setByAngle(angle);
        rotateTransition2.setRate(-2);
        rotateTransition2.setCycleCount(90);
        rotateTransition2.play();
    }

    @Override
    public void arrangeMe(double x,double y) {
        this.Xlayout=x;
        this.Ylayout=y;
        this.leftCircle.setLayoutX(x-80);
        this.leftCircle.setLayoutY(y);
        this.rightCircle.setLayoutX(x+80);
        this.rightCircle.setLayoutY(y);
        this.colorSwitch.setLayoutY(this.Ylayout+170);
        this.colorSwitch.setLayoutX(this.Xlayout);
    }
    @Override
    public void updateMyPosition(Pane p, List<Obstacle> myList, Obstacle o, int index,Group g) {
        //p.getChildren().removeAll(((DoubleCircle)o).rightCircle,((DoubleCircle)o).leftCircle);
        myList.remove(index);
        o.arrangeMe(500,-765);
        //p.getChildren().addAll(((DoubleCircle)o).rightCircle,((DoubleCircle)o).leftCircle);
        ((DoubleCircle)o).rightCircle.setVisible(true);
        ((DoubleCircle)o).leftCircle.setVisible(true);
        myList.add(o);
    }

    @Override
    public boolean checkCollision(Obstacle obj, Circle ball) {
        for (Node path:((DoubleCircle) obj).leftCircle.getChildren()){
            if(((Path)(javafx.scene.shape.Shape.intersect(ball,(javafx.scene.shape.Shape)path))).getElements().size()>0){
                System.out.println("Yessssssssssssssssssss");
                System.out.println(ball.getFill());
                System.out.println(((Shape) path).getStroke());
                if(!((Shape) path).getStroke().toString().equals(ball.getFill().toString())){
                    System.out.println(" ----------------------off same color");
                    return true;
                }
            }
        }
        for (Node path:((DoubleCircle) obj).rightCircle.getChildren()){
            if(((Path)(javafx.scene.shape.Shape.intersect(ball,(javafx.scene.shape.Shape)path))).getElements().size()>0){
                System.out.println("Yessssssssssssssssssss");
                System.out.println(ball.getFill());
                System.out.println(((Shape) path).getStroke());
                if(!((Shape) path).getStroke().toString().equals(ball.getFill().toString())){
                    System.out.println(" ----------------------off different color");
                    return true;
                }
            }
        }


        return false;
    }
}
