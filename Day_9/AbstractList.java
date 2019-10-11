import java.lang.*;
import java.util.*;

public abstract class AbstractList implements ListInterface{

    public int [] list;
    public int size;
    
    public AbstractList(){
        size = 0;
        list = new int [100];
    }

    // public void reSize(){
    //     list = Arrays.copyOf(list, 2 * size);
    // }

    public boolean contains(int item){
        // return indexOf(item) != -1;
        for(int i = 0; i < size; i++){
            if (list[i] == item){
                return true;
            }
        }
        return false;
    }

    public void remove(int index){
        if (index < size) {
            int i;
            for(i = index; i < size; i++) {
                list[i] = list[i+1];
            }
            list[i] = 0;
            size--;
        }
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
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
        String str = "[";
        int i;
        for(i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
}