package sorting;

import static javafx.scene.paint.Color.RED;

/**
 *
 * @author Brenden Cho
 */
public class Insertion extends SortingMethod {
    
public Insertion(int arrLength, int arrayAccesses,int comparisons,int time,Data [] d){
super(arrLength,arrayAccesses,comparisons,time,d);
sort();
}

@Override
public void sort(){

for(int x = 0; x < arrLength;x++){
int counter = x;
arrayAccesses += 2;
comparisons ++;
while((counter > 0) && (d[counter - 1].getValue() > d[counter].getValue())){
comparisons ++;
arrayAccesses += 6;
createHighlight(d[counter],RED,15);
Data temp = d[counter];
d[counter] = d[counter - 1];    
d[counter - 1] = temp;    
createSwap(d[counter],d[counter -1],time);    
time +=2;
counter--;    
    

}



}    
time+= 30;
done();    
    
    
    
    


} 



}    
    
    
    
    






