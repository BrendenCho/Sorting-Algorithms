package sorting;

import java.util.Random;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.AQUA;
import static javafx.scene.paint.Color.BLACK;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Brenden Cho
 */
public class MainData {

private int arrLength = 200;
private int windowLength = 1050;
private int windowHeight = 500;
private Data [] d = new Data[arrLength];
private Pane root;
private int delay;
private int comparisons = 0;
private int arrayAccesses= 0;
private int currentX = 0;
private int rectWidth = (windowLength - 50) /arrLength;
private int time = 0;    


    public MainData(Pane root){
    this.root = root;    
    }
    
   
    
    public void fill(Pane root){
    d =  new Data[arrLength];
    Random r = new Random();
    int temp = 0;
    for (int x = 0; x < arrLength;x++){
        d[x] =  new Data();
        temp = r.nextInt(windowHeight);
        d[x].setValue(temp);
        d[x].setRect(new Rectangle(currentX,windowHeight - temp ,rectWidth,temp));
        d[x].getRect().setFill(AQUA);
        d[x].getRect().setStroke(BLACK);
        currentX += windowLength/arrLength;
     
    }
       
    }

    public void erase(){
        for (int x = 0;x < arrLength;x++){
        root.getChildren().remove(d[x].getRect());
        }
        
         
    }
    
    public void draw(){
     for (int y = 0; y < arrLength;y++){
         root.getChildren().add(d[y].getRect());
     }    
    }
    
    public int getRectWidth() {
        return rectWidth;
    }

    public void setRectWidth(int rectWidth) {
        this.rectWidth = rectWidth;
    }

    public int getArrLength() {
        return arrLength;
    }

    public void setArrLength(int arrLength) {
        this.arrLength = arrLength;
    }

    public int getWindowLength() {
        return windowLength;
    }

    public void setWindowLength(int windowLength) {
        this.windowLength = windowLength;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public Data[] getD() {
        return d;
    }

    public void setD(Data[] d) {
        this.d = d;
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }

    public int getArrayAccesses() {
        return arrayAccesses;
    }

    public void setArrayAccesses(int arrayAccesses) {
        this.arrayAccesses = arrayAccesses;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

  
            
            
            
     
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

