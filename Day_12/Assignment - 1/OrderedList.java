/**
 * 
 */

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
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        if (size == list.length) {
            resize();
        }
        if (size == 0) {
            list[size++] = item;
        }else {
            int index = rank(item);
            for (int k=size; k>index; k--) {
                list[k] = list[k-1];
            }
            list[index] = item;
            size++;
        }
    }

    public int rank(int item) {
        int lo = 0, hi = size-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2;
            if      (item < list[hi]) hi = mid - 1; 
            else if (item > list[lo]) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    }
}