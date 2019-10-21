import java.util.Arrays;

public class OrderedList extends AbstractList {
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * The method returns void (nothing)
     */
    /**
     * @param arr .
     */
    public void addAll(final int[] arr) {
    }
    /**
     * @param lst .
     */
    public void addAll(final List lst) {
    }
    /**
     * @param index .
     * @param item .
     */
    public void add(final int index, final int item) {
    }
    /**
     * @param fromIndex .
     * @param toIndex .
     * @return .
     */
    public List subList(final int fromIndex, final int toIndex) {
        return null;
    }
    /**
     *  @param item .
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here....

        int tempSize = this.getSize();
        int[] tempList = this.getList();

        int listSize = tempList.length;


        if (listSize == tempSize) {
            tempList = Arrays.copyOf(tempList, listSize * 2);
        }
        tempList[tempSize] = item;
        tempSize = tempSize + 1;
        tempList = sortArray(tempList);

        this.setList(tempList);
        this.setSize(tempSize);

    }

    private int[] sortArray(final int[] newElements) {

        int tempSize = this.getSize();
        int[] tempList = this.getList();

        for (int i = 0; i < tempSize; i++) {
            for (int j = 0; j < tempSize - 1; j++) {
                int temp;
                if (newElements[j] > newElements[j + 1]) {
                    temp = newElements[j];
                    newElements[j] = newElements[j + 1];
                    newElements[j + 1] = temp;
                }
            }
        }
        return newElements;
    }

    /**
     * This method returns true if the item is present in this list.
     * If the item is not present, then return false.
     * @param item to be used to find whether it is present in this
     * list.
     * @return true if item is present in this list and false otherwise.
     */
    public boolean contains(final int item) {

        int tempSize = this.getSize();
        int[] tempList = this.getList();

        int left = 0;
        int right = tempSize - 1;
        int mid = -1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (tempList[mid] == item) {
                return true;
            }
            if (item < tempList[mid]) {
                right = mid - 1;
            }
            if (item > tempList[mid]) {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * This method returns the index of an item. If the item is not
     * present in the list, then return -1.
     * @param item to be used to find the index.
     * @return the index of the element if present, -1 otherwise.
     */
    public int indexOf(final int item) {

        int tempSize = this.getSize();
        int[] tempList = this.getList();

        int left = 0;
        int right = tempSize - 1;
        int mid = -1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (tempList[mid] == item) {
                return mid;
            }
            if (item < tempList[mid]) {
                right = mid - 1;
            }
            if (item > tempList[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
    /**
     * @param item .
     * @return .
     */
    public int rank(final int item) {

        int tempSize = this.getSize();
        int[] tempList = this.getList();

        int lo = 0;
        int hi = tempSize - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (item < tempList[hi]) {
                hi = mid - 1;
            } else if (item > tempList[lo]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}