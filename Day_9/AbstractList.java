import java.lang.*;
import java.util.*;

public class AbstractList implements ListInterface{

    public int [] list;
    public int size;
    
    public AbstractList(int capacity){
        size = 0;
        list = new int [capacity];
    }

    public void reSize(){
        list = Arrays.copyOf(list, 2 * size);
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
        // for(int i = 0; i < list.length; i++){
        //     if (arr[i] == item){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }
    }

    public void remove(int index){
        if (index > 0 && index < list.length) {
            for(int i = index; i < list.length; i++) {
                list[i] = list[i+1];
            }
            size--;
        }
    }

    public int get(int index) {
        if (index > 0 && index < list.length) {
            return list[index];
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public int indexOf(int item) {
        for(int i = 0; i < list.length; i++) {
            if(item == list[i]){
                return i;
            }
        }
        return -1;
    }
    
    public String toString() {
        if(size == 0)
            return "";
        String str = "[";
        int i = 0;
        for(i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
}