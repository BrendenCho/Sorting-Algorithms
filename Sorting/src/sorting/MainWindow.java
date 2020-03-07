package sorting;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Brenden Cho
 */
public class MainWindow {
    
    Pane root = new Pane();
    Scene scene = new Scene(root, 1000, 530);
    Stage primaryStage = new Stage();
    UserControl uc;  

    
    public MainWindow(){
    
        EventHandler <WindowEvent> onClose = new EventHandler <WindowEvent>(){
        
        public void handle(WindowEvent e){
        uc.closeStage();
        }
        
        
        };
        
        primaryStage.setOnCloseRequest(onClose);
        primaryStage.setResizable(false);
        primaryStage.setWidth(1005);
        primaryStage.setHeight(530);
        primaryStage.setTitle("Brenden Cho");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    } 

public void setRoot(Pane root){
this.root = root;
}

public void newScene(){
    primaryStage.close();

}

public void setUserControl(UserControl uc ){
this.uc = uc;
}

public Scene getScene() {
    return scene;
}

public void setScene(Scene scene) {
    this.scene = scene;
}

public Stage getPrimaryStage() {
    return primaryStage;
}

public void setPrimaryStage(Stage primaryStage) {
    this.primaryStage = primaryStage;
}

public UserControl getUc() {
    return uc;
}

public void setUc(UserControl uc) {
    this.uc = uc;
}


    
    
}
