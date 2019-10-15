import java.lang.*;
import java.util.*;

public class OrderedList extends AbstractList {
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     *
     * The method returns void (nothing)
     */
    /**
     *
     * @param index index position
     * @param item element to be added
     */

    public void arrange(final int index, final int item) {
        int[] temp = Arrays.copyOf(list, size + 1);
        int n = this.size;
        temp[n] = item;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            if (temp[j] > temp[j + 1]) {
                int temp1 = temp[j];
                temp[j] = temp[j + 1];
                temp[j + 1] = temp1;
            }
        }
    }
        list = temp;
        temp = null;
        size++;
    }
    /**
     *
     * @param item helps in deciding at whicho
     * the position where it to be inserted in list
     */
    public void help(final int item) {
        if (size == list.length) {
                resize();
        }
        this.list[size] = item;
        this.size += 1;
    }
    /**
     * adds the item in List at the specified position.
     * @param index item position and the element
     * @param item item to be inserted in List
     * to be added at that index position
     */
    public void add(final int index, final int item) {
        // TODO
        // Your code goes here.
        arrange(index, item);
 }

    /**
    * Thsi method adds the item in list but
    * does not return nothing.
    *@param item item to be added in the List
    */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here....
        if (size > 0) {
            if (size == list.length) {
                resize();
            }
            if (rank(item) < size) {
                arrange(rank(item), item);
            } else {
                help(item);
          }
        } else {
            help(item);
        }
}
    /**
     *
     * @param item elementy to be inserted in
     * list
     * @return the index position in
     * which the element to be inserted
     */
    public int rank(final int item) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (item < list[hi]) {
                hi = mid - 1;
            } else if (item > list[lo]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    
    // public static void main(final String[] args) {
    //     AbstractList list = new OrderedList();
    //     final int num1 = 0;
    //     final int num2 = 0;
    //     list.add(num1, num2);
    //     System.out.println(list);
    //     final int num3 = 1;
    //     list.add(num3);
    //     System.out.println(list);
    //     final int num4 = -1;
    //     list.add(num4);
    //     System.out.println(list);
    //     final int num5 = 4;
    //     list.add(num5);
    //     System.out.println(list);
    //     final int num6 = -2;
    //     list.add(num6);
    //     System.out.println(list);
    //     final int num7 = 2;
    //     final int num8 = 1;
    //     list.add(num7, num8);
    //     System.out.println(list);
    //     final int num9 = 4;
    //     list.add(num9);
    //     System.out.println(list);
    //     final int num10 = -2;
    //     list.add(num10);
    //     System.out.println(list);
    // }

}