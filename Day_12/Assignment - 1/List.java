import java.util.Arrays;

public class List extends AbstractList {
    /**
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the listay?
     * Think about how you can use the size variable to add item
     * to the list.
     * The method returns void (nothing)
     * @param item .
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here.
        int tempSize = this.getSize();
        int[] tempList = this.getList();
        int listSize = tempList.length;

        if (tempSize == listSize) {
            tempList = Arrays.copyOf(tempList, listSize * 2);
        }
        tempList[tempSize] = item;
        tempSize = tempSize + 1;
        this.setList(tempList);
        this.setSize(tempSize);
    }

    /**
     * Appends all of the elements in the specified list
     * to the end of this list, or
     * it will be added in order if the list is OrderedList, in the order that
     * they are returned by the specified list's Iterator.
     * @param lst list containing elements to be added to this list.
     */
    public void addAll(final List lst) {
        // TODO
        // Your code goes here.

        int tempSize = this.getSize();
        int[] tempList = this.getList();
        int[] currList = lst.getList();

        int lstSize = lst.getSize();
        tempList = Arrays.copyOf(tempList, tempSize + lstSize);

        for (int i = tempSize, j = 0; i < tempSize + lstSize && j < lstSize;
                         i++, j++) {
            tempList[i] = currList[j];
            tempSize = tempSize + 1;
        }
        this.setList(tempList);
        this.setSize(tempSize);
    }

    /**
     * This method adds all the items of the arr to this list.
     * @param arr is an array of items that should be added to
     * this list.
     */
    public void addAll(final int[] arr) {
        // TODO
        // Your code goes here.
        int arrSize = arr.length;

        int tempSize = this.getSize();
        int[] tempList = this.getList();

        tempList = Arrays.copyOf(tempList, tempSize + arrSize);
        for (int i = tempSize, j = 0; i < tempSize + arrSize && j < arrSize;
                     i++, j++) {
            tempList[i] = arr[j];
        }
        tempSize = tempSize + arrSize;

        this.setList(tempList);
        this.setSize(tempSize);

    }
     /**
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false.
     * @param item .
     * @return .
     */
    public boolean contains(final int item) {
        // TODO
        // Your code goes here.

        int tempSize = this.getSize();
        int[] tempList = this.getList();

        for (int i = 0; i < tempSize; i++) {
            if (tempList[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence
     *  of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param item .
     * @return .
     */
    public int indexOf(final int item) {
        // TODO
        // Your code goes here.

        int tempSize = this.getSize();
        int[] tempList = this.getList();

        for (int i = 0; i < tempSize; i++) {
            if (tempList[i] == item) {
                return i;
            }
        }
        return -1;
    }
}