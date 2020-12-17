package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Obstacle implements Serializable {
    public double Xlayout;
    public double Ylayout;
    public ImageView star;
    public Circle colorSwitch;
    public Circle colorStar;
    public Obstacle(double xlayout, double ylayout,ImageView star,Circle colorSwitch,Circle colorStar) {
        this.Xlayout = xlayout;
        this.Ylayout = ylayout;
        this.star=star;
        this.colorSwitch=colorSwitch;
        this.colorStar=colorStar;
    }

    public abstract void rotateMe(Group g,boolean reverse, int angle, int duration);

    public static void arrangeObstacles(List<Obstacle> myList,Pane p){
        for(int i=0;i<myList.size();i++){
         //   System.out.println(myList.get(i).getClass().getName());
        }
        Iterator it=myList.iterator();

        double y=335;
        while (it.hasNext()){
            //System.out.println(it.next());
            Object obj=it.next();
           if(obj instanceof ArcGroup){
                //System.out.println("loop 1");
                ((ArcGroup) obj).arrangeMe(500,y);
            }
            else if(obj instanceof Rectangel){
                //System.out.println("loop 2");
                ((Rectangel) obj).arrangeMe(500,y);
            }
            else if(obj instanceof Triangle){
                //System.out.println("loop 3");
                ((Triangle) obj).arrangeMe(500,y);
            }
            else{
                //System.out.println("loop 4");
                ((DoubleCircle)obj).arrangeMe(500,y);
                //System.out.println("loop 4_2");
            }
            y=y-400;
            System.out.println(y);
        }
    }

    public abstract void arrangeMe(double x,double y);
    public abstract void updateMyPosition(Pane p,List<Obstacle > myList,Obstacle o,int index,Group g);
    public abstract boolean checkCollision(Obstacle obj,Circle ball);


}
