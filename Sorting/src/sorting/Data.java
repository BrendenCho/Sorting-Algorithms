package sorting;

import javafx.scene.shape.Rectangle;


/**
 *
 * @author Brenden Cho
 */
public class Data {

private int value;
private Rectangle r;
private double currentX = 0;

public Data(){
    value = 0;
    r = new Rectangle();
}

public Data(int value,Rectangle r){
    this.value = value;
    this.r = r;
}

public void setCurrentX(double currentX){
    this.currentX = currentX;
}

public double getCurrentX(){
    return currentX;
}

public int getValue(){
    return value;
}

public Rectangle getRect(){
    return r;
}

public void setValue(int value){
    this.value = value;
}

public void setRect(Rectangle r){
    this.r = r;
}

public void setRect(double x, double y,double width,double height){
    r.setX(x);
    r.setY(y);
    r.setWidth(width);
    r.setHeight(height);
} 



}
