import java.util.*;
import java.lang.*;

public class OrderedList extends AbstractList{
    
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        if (size <= list.length) {
            list[size++] = item;
        }
        Arrays.sort(list);
    }

    // public int indexOf(int item) {
    //     for(int i = 0; i < size; i++) {
    //         if(item == list[i]){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
}