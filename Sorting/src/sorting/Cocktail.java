package sorting;

import static javafx.scene.paint.Color.RED;

/**
 *
 * @author Brenden Cho
 */
public class Cocktail extends SortingMethod {
 
public Cocktail(int arrLength, int arrayAccesses,int comparisons,int time,Data [] d){
super(arrLength,arrayAccesses,comparisons,time,d);
sort();
}    

@Override 
public void sort(){
    
    int cycle = 0;
    boolean done = false;
    int upperBound = arrLength - 1;
    int lowerBound = 0;

    while (done != true){
        int temp = cycle % 2;
        int swaps = 0;
        
        if(temp == 0){
            cycle++;
            for(int x = lowerBound;x < upperBound;x++){
                time+=1;
                createHighlight(d[x],RED,15);
                arrayAccesses += 2;
                comparisons++;
                if(d[x+1].getValue() < d[x].getValue()){
                    time+=1;
                    createSwap(d[x],d[x+1],time);
                    Data dd = d[x];
                    d[x] = d[x+1];
                    d[x+1] = dd;
                    arrayAccesses+= 6;
                    swaps++;        
                }
            }
        upperBound--;
        }
        else {
            cycle++;
            for(int x = upperBound;x > lowerBound;x--){
                time+=1;
                createHighlight(d[x],RED,15);
                arrayAccesses += 2;
                comparisons++;
                if(d[x-1].getValue() > d[x].getValue()){
                    time+=1;
                    createSwap(d[x-1],d[x],time);
                    Data dd = d[x];
                    d[x] = d[x-1];
                    d[x-1] = dd;
                    arrayAccesses+= 6;
                    swaps++;
                }
            }
        lowerBound++;
        
        }
        if (swaps == 0){
        done = true;
        }
    
    }
    done();

}



}
