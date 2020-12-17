package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serealize implements Serializable {
    public List<Obstacle > myList=new ArrayList<>(6);


    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score =ClassBall.getScore();
    }

    private int score=0;

    public void setMyList() {
        this.myList = BackgroundCanvas.myList;
    }
    public void saveButtonClicked() throws IOException {
//        Serealize s=new Serealize();
//        s.setMyList();
//        s.setScore();
//        File f=new File("obj,txt");
//        FileOutputStream fos=new FileOutputStream(f);
//        ObjectOutputStream oos= new ObjectOutputStream(fos);
//        oos.writeObject(s);

    }



}
