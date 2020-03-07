package sorting;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 *
 * @author Brenden Cho
 */
public class UserControl {

Stooge stooge;    
Comb comb;
Gnome gnome;
Quick quick;
Selection select;
Bubble bubble;
MainData md;
MainWindow mw;
Sorting s;
Cocktail cocktail;
Insertion insert;


HBox h = new HBox();    
Stage stage = new Stage();
Button randomize = new Button("Randomize");
ObservableList<String> options = FXCollections.observableArrayList("Selection Sort","Bubble Sort","Cocktail Sort","Insertion Sort","Quick Sort", "Gnome Sort","Comb Sort","Stooge Sort");
Button start = new Button("Start");
final ComboBox cb = new ComboBox(options);
Alert userError = new Alert(AlertType.INFORMATION);
Alert result = new Alert(AlertType.INFORMATION);


public UserControl(MainWindow mw, Sorting s, MainData md){
    
    this.mw = mw;
    this.s = s;
    this.md = md;
    
    h.setPadding(new Insets(2.5,2.5,2.5,2.5));
    h.setSpacing(5);

    userError.setContentText("Please Choose an Option!");

EventHandler<WindowEvent> onClose = new EventHandler<WindowEvent>(){

    public void handle(WindowEvent e){
        closeWindow();
    }


};



EventHandler<ActionEvent> Randomize = new EventHandler<ActionEvent>(){

    public void handle(ActionEvent e){
        System.out.println("Randomize Bttn pressed");
        s.quickWindow();
        setmd();
    }

};

EventHandler<ActionEvent> Start = new EventHandler<ActionEvent>(){

    public void handle(ActionEvent e){
        System.out.println("Start Bttn pressed");
        String temp="";
   
        try{
            temp = cb.getValue().toString();
            System.out.println(temp);
        }catch (NullPointerException n){
            System.err.println("No Value Selected");
            userError.show();
        }
        
        switch (temp){
    
        case "Bubble Sort":
    
            startBubble();   
            disable(bubble);
        
        break;
        
        case "Selection Sort":
            
            startSelection();
            disable(select);
            
        break;
    
        case "Cocktail Sort":
    
            startCocktail();
            disable(cocktail);
        
        break;
       
        case "Insertion Sort":
            
            startInsertion();
            disable(insert);
        
        break;    
        
        case "Quick Sort":
    
            startQuick();
            disable(quick);
        
        break;
        
        case "Gnome Sort":
    
            startGnome();
            disable(gnome);
        
        break;
        
        case "Comb Sort":
    
            startComb();
            disable(comb);
        
        break;
        
        case "Stooge Sort":
    
            startStooge();
            disable(stooge);
        
        break;
        }
       
    }

};

    randomize.setOnAction(Randomize);
    start.setOnAction(Start);

    h.getChildren().add(randomize);
    h.getChildren().add(cb);
    h.getChildren().add(start);

    Scene scene = new Scene(h);

    stage.setY(mw.primaryStage.getY());
    stage.setX(mw.primaryStage.getX() + 1200);
    stage.setWidth(260);
    stage.setHeight(60);
    stage.setTitle("Brenden Cho");
    stage.setResizable(false);
    stage.setScene(scene);
    stage.setOnCloseRequest(onClose);
    stage.show();
}

public void setmd(){
    this.md = s.md;
    this.mw = s.mw;
}

public void startBubble(){
    Bubble bubble = new Bubble(md.getArrLength(),md.getArrayAccesses(),md.getComparisons(),md.getTime(),md.getD()); 
    this.bubble = bubble;
}

public void disable(Bubble b){
    result.setTitle("Brenden Cho");
    result.setContentText("Comparisons:"+ b.comparisons + " Array Accesses:"+b.arrayAccesses);
    randomize.setDisable(true);
    cb.setDisable(true);
    start.setDisable(true);
            
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(b.time));
            
    p.setOnFinished((ActionEvent ee) -> {
        result.show();
        randomize.setDisable(false);
        cb.setDisable(false);
        start.setDisable(false);
    });

    p.play();
}

public void disable(Selection s){
    result.setTitle("Brenden Cho");
    result.setContentText("Comparisons:"+ s.comparisons + " Array Accesses:"+s.arrayAccesses);
    randomize.setDisable(true);
    cb.setDisable(true);
    start.setDisable(true);
            
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(s.time));
            
    p.setOnFinished((ActionEvent ee) -> {
        result.show();
        randomize.setDisable(false);
        cb.setDisable(false);
        start.setDisable(false);
    });

    p.play();
}

public void disable(Cocktail c){
    result.setTitle("Brenden Cho");
    result.setContentText("Comparisons:"+ c.comparisons + " Array Accesses:"+c.arrayAccesses);
    randomize.setDisable(true);
    cb.setDisable(true);
    start.setDisable(true);
            
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(c.time));
            
    p.setOnFinished((ActionEvent ee) -> {
        result.show();
        randomize.setDisable(false);
        cb.setDisable(false);
        start.setDisable(false);
    });

    p.play();
}

public void disable(Insertion i){
    result.setTitle("Brenden Cho");
    result.setContentText("Comparisons:"+ i.comparisons + " Array Accesses:"+i.arrayAccesses);
    randomize.setDisable(true);
    cb.setDisable(true);
    start.setDisable(true);
            
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(i.time));
            
    p.setOnFinished((ActionEvent ee) -> {
        result.show();
        randomize.setDisable(false);
        cb.setDisable(false);
        start.setDisable(false);
    });

    p.play();
}

public void disable(Quick q){
    result.setTitle("Brenden Cho");
    result.setContentText("Comparisons:"+ q.comparisons + " Array Accesses:"+q.arrayAccesses);
    randomize.setDisable(true);
    cb.setDisable(true);
    start.setDisable(true);
            
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(q.time));
            
    p.setOnFinished((ActionEvent ee) -> {
        result.show();
        randomize.setDisable(false);
        cb.setDisable(false);
        start.setDisable(false);
    });

    p.play();
}

public void disable(Gnome g){
    result.setTitle("Brenden Cho");
    result.setContentText("Comparisons:"+ g.comparisons + " Array Accesses:"+g.arrayAccesses);
    randomize.setDisable(true);
    cb.setDisable(true);
    start.setDisable(true);
            
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(g.time));
            
    p.setOnFinished((ActionEvent ee) -> {
        result.show();
        randomize.setDisable(false);
        cb.setDisable(false);
        start.setDisable(false);
    });

    p.play();
}

public void disable(Comb c){
    result.setTitle("Brenden Cho");
    result.setContentText("Comparisons:"+ c.comparisons + " Array Accesses:"+c.arrayAccesses);
    randomize.setDisable(true);
    cb.setDisable(true);
    start.setDisable(true);
            
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(c.time));
            
    p.setOnFinished((ActionEvent ee) -> {
        result.show();
        randomize.setDisable(false);
        cb.setDisable(false);
        start.setDisable(false);
    });

    p.play();
}

public void disable(Stooge s){
    result.setTitle("Brenden Cho");
    result.setContentText("Comparisons:"+ s.comparisons + " Array Accesses:"+s.arrayAccesses);
    randomize.setDisable(true);
    cb.setDisable(true);
    start.setDisable(true);
            
    PauseTransition p = new PauseTransition();
    p.setDuration(Duration.millis(s.time));
            
    p.setOnFinished((ActionEvent ee) -> {
        result.show();
        randomize.setDisable(false);
        cb.setDisable(false);
        start.setDisable(false);
    });

    p.play();
}

public void closeWindow(){
    mw.newScene();
}

public void closeStage(){
    stage.close();
}

public void startSelection(){
    Selection select = new Selection(md.getArrLength(),md.getArrayAccesses(),md.getComparisons(),md.getTime(),md.getD()); 
    this.select = select;
}

public void startCocktail(){
    Cocktail cocktail = new Cocktail(md.getArrLength(),md.getArrayAccesses(),md.getComparisons(),md.getTime(),md.getD()); 
    this.cocktail = cocktail;
}

public void startInsertion(){
    Insertion insert = new Insertion(md.getArrLength(),md.getArrayAccesses(),md.getComparisons(),md.getTime(),md.getD()); 
    this.insert = insert;
}

public void startQuick(){
    Quick quick = new Quick(md.getArrLength(),md.getArrayAccesses(),md.getComparisons(),md.getTime(),md.getD()); 
    this.quick = quick;
}

public void startGnome(){
    Gnome gnome= new Gnome(md.getArrLength(),md.getArrayAccesses(),md.getComparisons(),md.getTime(),md.getD()); 
    this.gnome = gnome;
}

public void startComb(){
    Comb comb= new Comb(md.getArrLength(),md.getArrayAccesses(),md.getComparisons(),md.getTime(),md.getD()); 
    this.comb = comb;
}

public void startStooge(){
    Stooge stooge = new Stooge(md.getArrLength(),md.getArrayAccesses(),md.getComparisons(),md.getTime(),md.getD()); 
    this.stooge = stooge;
}

public Stooge getStooge() {
    return stooge;
}

public void setStooge(Stooge stooge) {
    this.stooge = stooge;
}

public Comb getComb() {
    return comb;
}

public void setComb(Comb comb) {
    this.comb = comb;
}

public Gnome getGnome() {
    return gnome;
}

public void setGnome(Gnome gnome) {
    this.gnome = gnome;
}

public Quick getQuick() {
    return quick;
}

public void setQuick(Quick quick) {
    this.quick = quick;
}

public Selection getSelect() {
    return select;
}

public void setSelect(Selection select) {
    this.select = select;
}

public Bubble getBubble() {
    return bubble;
}

public void setBubble(Bubble bubble) {
    this.bubble = bubble;
}

public MainData getMd() {
    return md;
}

public void setMd(MainData md) {
    this.md = md;
}

public MainWindow getMw() {
    return mw;
}

public void setMw(MainWindow mw) {
    this.mw = mw;
}

public Sorting getS() {
    return s;
}

public void setS(Sorting s) {
    this.s = s;
}

public Cocktail getCocktail() {
    return cocktail;
}

public void setCocktail(Cocktail cocktail) {
    this.cocktail = cocktail;
}

public Insertion getInsert() {
    return insert;
}

public void setInsert(Insertion insert) {
    this.insert = insert;
}

public HBox getH() {
    return h;
}

public void setH(HBox h) {
    this.h = h;
}

public Stage getStage() {
    return stage;
}

public void setStage(Stage stage) {
    this.stage = stage;
}

public Button getRandomize() {
    return randomize;
}

public void setRandomize(Button randomize) {
    this.randomize = randomize;
}

public ObservableList<String> getOptions() {
    return options;
}

public void setOptions(ObservableList<String> options) {
    this.options = options;
}

public Button getStart() {
    return start;
}

public void setStart(Button start) {
    this.start = start;
}

public Alert getUserError() {
    return userError;
}

public void setUserError(Alert userError) {
    this.userError = userError;
}

public Alert getResult() {
    return result;
}

public void setResult(Alert result) {
    this.result = result;
}


}