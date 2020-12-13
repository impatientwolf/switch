package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public abstract class Obstacle  {
    private static Group newArch;
    private  static List<Obstacle> myList=new ArrayList<>(6);
    Controller cont =new Controller();
  public static void addObstacles(Pane p1){ //initial addition
            for(int i=0;i<6;i++){
              myList.add(new ArcGroup(newArch));
            }




  }

   public static void temporyEquate(Group c){
      newArch =c;
   }



}
