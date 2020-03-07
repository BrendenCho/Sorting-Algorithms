package sorting;

/**
 *
 * @author Brenden Cho
 */
public class Stooge extends SortingMethod {

public Stooge(int arrLength, int arrayAccesses,int comparisons,int time,Data [] d){
super(arrLength,arrayAccesses,comparisons, time,d);
sort();
}

@Override
public void sort(){
s(0,199);
time += 40;
done();
}

public void s(int i,int len){
comparisons++;
arrayAccesses += 2;
if (d[i].getValue() > d[len].getValue())
{
arrayAccesses += 6;
Data temp = d[i];
d[i] = d[len];
d[len] = temp;
createSwap(d[i],d[len],time);
time ++;
}

if ((len - i + 1) > 2){
    int t = (len - i + 1)/3;
    s(i,len - t);
    s(i+t,len);
    s(i,len - t);
}

}



}
