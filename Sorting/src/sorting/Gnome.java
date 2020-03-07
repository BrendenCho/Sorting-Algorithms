package sorting;

import static javafx.scene.paint.Color.RED;

/**
 *
 * @author Brenden Cho
 */
public class Gnome extends SortingMethod{

public Gnome(int arrLength, int arrayAccesses,int comparisons,int time,Data [] d){
super(arrLength,arrayAccesses,comparisons, time,d);
sort();
}

@Override
public void sort(){

int index = 0;

while(index < 200){

if (index == 0){
index ++;
}    
comparisons++;
arrayAccesses += 2;
createHighlight(d[index],RED,15);
if (d[index].getValue() >= d[index - 1].getValue()){
index++;
}else{
arrayAccesses += 6;
Data temp = d[index];
d[index] = d[index - 1];
d[index - 1] = temp;
createSwap(d[index], d[index -1],time);
time += 1;
index--;
}
}
time += 25;    
done();   
    
    

}



    
}
