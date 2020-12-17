package sample;

import javafx.animation.RotateTransition;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.awt.*;
import java.io.Closeable;
import java.util.List;
import java.util.Random;

public class ArcGroup extends Obstacle {
    public Group  arcGroup;

    public ArcGroup(Group myarc,double x,double y,ImageView star,Circle colorSwitch,Circle colorStar) {
        super(x,y,star,colorSwitch,colorStar);
        this.arcGroup=myarc;
    }


    @Override
    public void rotateMe(Group g,boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), this.arcGroup);
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
     this.arcGroup.setLayoutX(x);
     this.arcGroup.setLayoutY(y);
     this.star.setLayoutY(this.Ylayout-20);
     this.star.setLayoutX(this.Xlayout-20);
        this.colorStar.setLayoutY(this.Ylayout+4);
        this.colorStar.setLayoutX(this.Xlayout);
     this.colorSwitch.setLayoutY(this.Ylayout+170);
     this.colorSwitch.setLayoutX(this.Xlayout);
        this.colorStar.setVisible(false);
       /// System.out.println("star coordinates updated");
    }

    @Override
    public void updateMyPosition(Pane p, List<Obstacle> myList, Obstacle o, int index,Group g) {
        //p.getChildren().remove(g);
        myList.remove(index);
        System.out.println("I was removed successfully---Arc Group");
        o.arrangeMe(500,-765);
        //g.setLayoutY(-1665);
        //p.getChildren().add(((ArcGroup) o).arcGroup);
        ((ArcGroup) o).arcGroup.setVisible(true);
        myList.add(o);
        System.out.println("I was added successfully---Arc Group");

    }

    @Override
    public boolean checkCollision(Obstacle obj, Circle ball) {
        for (Node path:((ArcGroup) obj).arcGroup.getChildren()){
            if(((Path)(javafx.scene.shape.Shape.intersect(ball,(javafx.scene.shape.Shape)path))).getElements().size()>0){
                System.out.println("Yessssssssssssssssssss touched arcGroup");
                System.out.println(ball.getFill());
                System.out.println(((Shape) path).getStroke());
                if(!((Shape) path).getStroke().toString().equals(ball.getFill().toString())){
                    System.out.println(" ----------------------off dufferent color -- arc group");
                    return true;
                }
            }
        }


        return false;
    }
}
