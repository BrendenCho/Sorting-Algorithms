package sorting;

import static javafx.scene.paint.Color.RED;

/**
 *
 * @author Brenden Cho
 */
public class Quick extends SortingMethod {

public Quick(int arrLength, int arrayAccesses,int comparisons,int time,Data [] d){
super(arrLength,arrayAccesses,comparisons, time,d);
sort();
}

@Override
public void sort(){
quick(d,0,199);
done();
}

public void quick(Data[] d,int low,int high){
comparisons++;
if (low < high){

int part = partition(d,low,high);


quick(d,low,part - 1);
quick(d,part+1,high);



}
time += 30;

}

public int partition(Data[] d,int low,int high){
int pivot = high;

int i = low - 1;

for (int x = low; x < high; x++){
    createHighlight(d[x],RED,25);
    time += 1;
    comparisons++;
    arrayAccesses += 2;
    if (d[x].getValue() < d[pivot].getValue()){
    i++;
    arrayAccesses += 5;
    Data temp = d[i];
    d[i] = d[x];
    d[x] = temp;
    createSwap(d[x],d[i],time);
    time += 1;
    }

}
arrayAccesses += 5;
Data temp = d[i+1];
d[i+1] = d[high];
d[high] = temp;
createSwap(d[i+1],d[high],time);
time += 1;
return i+1;
}




}
