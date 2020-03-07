package sorting;

import static javafx.scene.paint.Color.RED;

/**
 *
 * @author Brenden Cho
 */
public class Bubble extends SortingMethod{
    
public Bubble(int arrLength, int arrayAccesses,int comparisons,int time,Data [] d){
super(arrLength,arrayAccesses,comparisons,time,d);
sort();
}
   
@Override 
public void sort(){

 boolean done = false;
    int index = arrLength - 1;
   
    while(done != true){
       
        int counter = 0;
     
        for(int x = 0; x < index;x++){
            arrayAccesses+= 2;
            comparisons += 1;
            createHighlight(d[x],RED,15);
            time += 1;    
            
            if (d[x+1].getValue() < d[x].getValue()){
                arrayAccesses+= 4;
                Data temp = d[x]; 
                d[x] = d[x+1];
                d[x+1] = temp;
                createSwap(d[x],d[x+1],time);        
                time += 1;
                counter++;
            }
       
        }
        
        index --;
       
        if (counter == 0){
            done = true;
        }
    }
    
    done();


}
    
 


   
    
    
    
    
}
