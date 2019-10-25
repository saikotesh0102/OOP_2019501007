public interface ListInterface<E extends Comparable<E>> {
    /**
     * Adds an item to this List.
     */
    public void add(E item);
   
    /**
     * Thid method returns the number of elements in this list.
     * if list is empty, then it returns 0 by default.
     * @return the number of elements in this list.
     */
    public int size();

    /**
     * Returns an item at a particular index from this list
     * @param index to be used to return the element
     * @return the element at a particular index
     * @throws InvalidIndexException if the index is not valid
     */
    public E get(int index) throws InvalidIndexException;

    /**
     * This method returns the index of an item. If the item is not
     * present in the list, then return -1.
     * @param item, to be used to find the index.
     * @return the index of the element if present, -1 otherwise.
     */
    public int indexOf(E item);

    /**
     * This method returns true if the item is present in this list.
     * If the item is not present, then return false.
     * @param item, to be used to find whether it is present in this
     * list.
     * @return true if item is present in this list and false otherwise.
     */
    public boolean contains(E item);
    
    /**
     * This method will removes the element at a particular index.
     * Think of once you remove the element, there will be a empty
     * space.
     * 
     * Now move all the items to the left by one position.
     * 
     * Please see the comemnts in Assignment - 2 for more details 
     * in Polymorphism and Abstract Data Type.
     * 
     * @param item, to be removed from a particular index in this list.
     * @throws throws an exceptions if the index is not in bounds.
     */
    public void remove(int index) throws InvalidIndexException;

    /**
     * Adds all the elements of arr to this list.
     * @param arr to be added to this list.
     */
    public void addAll(E[] arr);
    
    /**
     * This method returns the last index of the element. if not 
     * found returns -1
     * @param item to be searched in this list.
     * @return the last index of the item from this list otherwise
     * returns -1
     */
    public int lastIndexOf(E item);

    /**
     * This method returns the number of occurances of the item
     * in this list.
     * @param item to be counted.
     * @return the number of occurances in this list.
     */
    public int count(E item);

    /**
     * This method returns the sublist from this list based on 
     * fromIndex and toIndex.
     * @param fromIndex the new list contains the elements based on
     * fromIndex in this list.
     * @param toIndex the new list contains the elements upto
     * toIndex in this list.
     * @return a List which is a subList of this list.
     * @throws InvalidIndexException if fromIndex and toIndex is invalid.
     */
    public List<E> subList(int fromIndex, int toIndex) throws InvalidIndexException;

    /**
     * This method adds all the elements of lst to this list.
     * @param lst to be added to this list.
     * @throws InvalidIndexException if fails in retrieving 
     * the elements from lst.
     */
    public void addAll(List<E> lst) throws InvalidIndexException;
}