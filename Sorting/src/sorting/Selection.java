package sorting;

import static javafx.scene.paint.Color.RED;

/**
 *
 * @author Brenden Cho
 */
public class Selection extends SortingMethod {

public Selection(int arrLength, int arrayAccesses,int comparisons,int time,Data [] d){
super(arrLength,arrayAccesses,comparisons,time,d);
sort();
}

@Override
public void sort(){

int index = 0;    
    
for (int x = 0; x < arrLength;x++){
    index = x;
    
    for (int y = x + 1; y < arrLength;y++){
        createHighlight(d[y],RED,25);
        time += 1;
        comparisons++;
        arrayAccesses += 2;
        if (d[y].getValue() < d[index].getValue()){
        index = y;
        }
    
    }
     time += 15;
    if (index != x){
    createSwap(d[x],d[index],time);
   arrayAccesses+= 4;
    Data temp = d[x];
    d[x] = d[index];
    d[index] = temp;
    }
}

done();

}

    
}
