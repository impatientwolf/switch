package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Obstacle {
    public double Xlayout;
    public double Ylayout;

    public Obstacle(double xlayout, double ylayout) {
        Xlayout = xlayout;
        Ylayout = ylayout;
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
                System.out.println("loop 1");
                ((ArcGroup) obj).arrangeMe(500,y);
            }
            else if(obj instanceof Rectangel){
                System.out.println("loop 2");
                ((Rectangel) obj).arrangeMe(500,y);
            }
            else if(obj instanceof Triangle){
                System.out.println("loop 3");
                ((Triangle) obj).arrangeMe(500,y);
            }
            else{
                System.out.println("loop 4");
                ((DoubleCircle)obj).arrangeMe(500,y);
                System.out.println("loop 4_2");
            }
            y=y-300;
            System.out.println(y);
        }
    }

    public abstract void arrangeMe(double x,double y);


}
