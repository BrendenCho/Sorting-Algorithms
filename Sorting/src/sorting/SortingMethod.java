package sorting;

import javafx.animation.FillTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.CYAN;
import static javafx.scene.paint.Color.GREEN;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Brenden Cho
 */
public abstract class SortingMethod {

int arrLength;
int arrayAccesses;
int comparisons;
int time; 
Data[] d;
 
 SortingMethod(int arrLength, int arrayAccesses, int comparisons, int time, Data[] d){
    
    this.arrLength = arrLength;
    this.arrayAccesses = arrayAccesses;
    this.comparisons = comparisons;
    this.time = time;
    this.d = d;
 }
 
public abstract void sort();

private void highlight(Data d, Color c,int time){
    FillTransition ft = new FillTransition();
    ft.setDuration(Duration.millis(time));
    ft.setFromValue(c);
    ft.setToValue(CYAN);
    ft.setShape(d.getRect());
    ft.play();
}    
   
private void highlight(Data d, Color c){
    FillTransition ft = new FillTransition();
    ft.setDuration(Duration.millis(20));
    ft.setFromValue(c);
    ft.setToValue(CYAN);
    ft.setShape(d.getRect());
    ft.play();
}
   
public void drawAll(Pane p,Rectangle [] rectArr){
    for (int x = 0; x < rectArr.length;x++){
        p.getChildren().add(rectArr[x]);
    }
}

public void draw(Pane p,Rectangle r){
    p.getChildren().add(r);
}

private void swap(Data d, Data d1){
    
    double distance; 
    double relativeX = d.getRect().getX() + d.getCurrentX();
    double relativeX1 = d1.getRect().getX() + d1.getCurrentX();

    TranslateTransition t1 = new TranslateTransition(Duration.millis(20),d.getRect()); 
    TranslateTransition t2 = new TranslateTransition(Duration.millis(20),d1.getRect());    

    t1.setFromX(d.getCurrentX());
    t2.setFromX(d1.getCurrentX());

    if (d1.getRect().getX() > d.getRect().getX()){
        distance = relativeX1 - relativeX;
        d.setCurrentX(d.getCurrentX() + distance);
        d1.setCurrentX(d1.getCurrentX() - distance);
    }
    else{
        distance = relativeX  -relativeX1; 
        d.setCurrentX(d.getCurrentX() - distance);
        d1.setCurrentX(d1.getCurrentX() + distance);
    }

    t1.setToX(d.getCurrentX());
    t2.setToX(d1.getCurrentX());

    t1.play();
    t2.play();     


}

public void createSwap(Data dd, Data dd1, int time){
    PauseTransition p1 = new PauseTransition();
    p1.setDuration(Duration.millis(time));
    final Data d1 = dd;
    final Data d2 = dd1;
        
    p1.setOnFinished((ActionEvent e) -> {
        swap(d1,d2);
    });
        
    p1.play();

}

public void createHighlight(Data d ,Color c){
    final Data dh = d;
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(time));
            
    p.setOnFinished((ActionEvent e) -> {
        highlight(dh,c);    
    });

    p.play();
}

public void createHighlight(Data d ,Color c,int timeHighlighted){
    final Data dh = d;
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(time));
            
    p.setOnFinished((ActionEvent e) -> {
        highlight(dh,c,timeHighlighted);    
    });

    p.play();
}

public void done(){
    for (int a = 0;a < arrLength;a++){
        createHighlight(d[a],GREEN,2500);
    }

    System.out.println("Comparsions:"+comparisons);
    System.out.println("Array Acesses:"+arrayAccesses);

}






    
}
