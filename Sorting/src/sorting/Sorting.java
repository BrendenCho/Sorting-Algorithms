package sorting;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import static javafx.scene.paint.Color.CYAN;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Brenden Cho
 */
public class Sorting extends Application {
     
    MainWindow mw = new MainWindow();
    MainData md = new MainData(mw.root);
    UserControl uc = new UserControl(mw,this, md);
  
     public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        mw.setUserControl(uc);
        md.fill(mw.root);
        md.draw();
        setAllHandlers();   
    }

    public void quickWindow(){
        mw.newScene();
        mw = new MainWindow();
        mw.uc = uc;
        md = new MainData(mw.root);
        md.fill(mw.root);
        md.draw(); 
        setAllHandlers();
    }
    
    public void setHandlers(Rectangle r,int index){
    
       final Text t = new Text(Integer.toString(md.getD()[index].getValue()));
       final Rectangle rect= r; 
        EventHandler<MouseEvent> enter = new EventHandler<MouseEvent>(){
        
        
        public void handle(MouseEvent e){
        rect.setFill(RED);
        t.setX(470);
        t.setY(20);
        t.setFont(Font.font("Verdana",FontWeight.BOLD,20));
        mw.root.getChildren().add(t);
        } 
        };
        
        EventHandler<MouseEvent> exit = new EventHandler<MouseEvent>(){
        final Rectangle rect = r;
        public void handle(MouseEvent e){
        rect.setFill(CYAN);
        mw.root.getChildren().remove(t);
        } 
        }; 
        
        
        md.getD()[index].getRect().setOnMouseEntered(enter);
        md.getD()[index].getRect().setOnMouseExited(exit);
         
    }
   
    public void setAllHandlers(){
    
    for(int x = 0; x < 200; x++){
    setHandlers(md.getD()[x].getRect(),x); 
    }
    
    
    }
   
   
   
}
