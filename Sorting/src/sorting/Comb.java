package sorting;

import static javafx.scene.paint.Color.RED;

/**
 *
 * @author Brenden Cho
 */
public class Comb extends SortingMethod{

public Comb(int arrLength, int arrayAccesses,int comparisons,int time,Data [] d){
super(arrLength,arrayAccesses,comparisons, time,d);
sort();
}

@Override
public void sort(){

int arrLength = 200;
int gap = 200;
    
boolean swap = true;
    
while(gap != 1 || swap == true){

gap = gap * 10 / 13;
if (gap < 1){
gap = 1;
}

swap = false;

for (int x = 0; x < arrLength - gap;x++){
comparisons ++;
createHighlight(d[x],RED,15);
if (d[x].getValue() > d[x + gap].getValue()){
arrayAccesses += 6;
Data temp = d[x];
d[x] = d[x+gap];
d[x+gap] = temp;
createSwap(d[x],d[x+gap],time);
time += 5;
swap = true;

}

}

}    
time += 25;
done();
    

}



    
}
