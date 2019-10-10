import java.util.*;
import java.lang.*;

public class OrderedList extends AbstractList{

    public OrderedList(){
        super();
    }
    
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        if (size >= list.length) {
            reSize();
        }
        list[size++] = item;
        Arrays.sort(list);
    }

    public int indexOf(int item) {
        for(int i = 0; i < list.length; i++) {
            if(item == list[i]){
                return i;
            }
        }
        return -1;
    }
}