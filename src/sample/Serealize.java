package sample;

import javafx.scene.shape.Circle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serealize implements Serializable {
    public ArrayList<Obstaclecoordinates> myList;


    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score =ClassBall.getScore();
    }

    private int score=0;
    private double ballCentreX;
    private  double ballCentrey;


    public void saveButtonClicked(Circle ball) throws IOException {
      Serealize s=new Serealize();
      s.myList=new ArrayList<>(6);
        Obstaclecoordinates obj;
      for (Obstacle o:BackgroundCanvas.myList){
           obj=new Obstaclecoordinates();
           if(o instanceof ArcGroup){
               obj.flag=1;
               obj.Xlayout=o.Xlayout;
               obj.Ylayout=o.Ylayout;
               if(o.star.isVisible()){
                   obj.Flagstar=1;
               }
               if(o.colorSwitch.isVisible()){
                   obj.FlagColorSwitch=1;
               }
           }
           else if(o instanceof Rectangel){
               obj.flag=2;
               obj.Xlayout=o.Xlayout;
               obj.Ylayout=o.Ylayout;
               if(o.star.isVisible()){
                   obj.Flagstar=1;
               }
               if(o.colorSwitch.isVisible()){
                   obj.FlagColorSwitch=1;
               }
           }
           else if(o instanceof Triangle){
               obj.flag=3;
               obj.Xlayout=o.Xlayout;
               obj.Ylayout=o.Ylayout;
               if(o.star.isVisible()){
                   obj.Flagstar=1;
               }
               if(o.colorSwitch.isVisible()){
                   obj.FlagColorSwitch=1;
               }
           }
           else{
               obj.flag=4;
               obj.Xlayout=o.Xlayout;
               obj.Ylayout=o.Ylayout;
               if((o.star!=null)&&(o.star.isVisible())){
                   obj.Flagstar=1;
               }
               if(o.colorSwitch.isVisible()){
                   obj.FlagColorSwitch=1;
               }
           }
           s.myList.add(obj);
       }
       s.ballCentreX=ball.getCenterX();
       s.ballCentrey=ball.getCenterY();
       s.score=ClassBall.getScore();

 //        s.setMyList();
//        s.setScore();
       File f=new File("obj,txt");
        FileOutputStream fos=new FileOutputStream(f);
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        oos.writeObject(s);

    }

    class Obstaclecoordinates implements Serializable{
        int flag; //1234
        double Xlayout;
        double Ylayout;
        int Flagstar;// 1 if yes
        int FlagColorSwitch; // 1 if yes

    }


}
