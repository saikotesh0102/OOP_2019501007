import java.util.*;

public class List extends AbstractList {

    /**
     * add item to the list.
     * @param item element to be added
     */

    public void add(final int item) {
        if (size == list.length) {
            resize();
        }
        this.list[size] = item;
        this.size++;
    }
    /**
     * adds a item at the specified position.
     * @param index index position
     * @param item element to be added
     */
    public void add(final int index, final int item) {
        // TODO
        // Your code goes here.
        int[] temp = Arrays.copyOf(list, size + 1);
        // temp = list;
        int index1 = index;
        if (index1 <= size && index1 >= 0) {
            temp[index1] = item;
            for (int j = index1 + 1; j <= size; j++) {
                temp[j] = list[index1];
                index1 += 1;
            }
        list = temp;
        temp = null;
        size++;
        }

    }
}