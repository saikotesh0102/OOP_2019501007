import java.lang.*;
import java.util.*;

public class AbstractList implements ListInterface{

    private int [] list;
    private int size;
    
    public AbstractList(int capacity){
        size = 0;
        list = new int [capacity];
    }

    public void reSize(){
        list = Arrays.copyOf(list, 2 * size);
    }

    public booleanContains(int item){
        // return indexOf(item) != -1;
        for(int i = 0; i < list.length; i++){
            if (arr[i] == item){
                return true;
            }else{
                return false;
            }
        }
    }

    public void remove(int index){
        if (index > 0 && index < list.length) {
            for(int i = index; i < list.length; i++) {
                list[i] = list[i+1];
            }
            size--;
        }
    }

    public int indexOf(int item) {
        for(int i = 0; i < list.length; i++) {
            if(item == list[i]){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return size;
    }
}