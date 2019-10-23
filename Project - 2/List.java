class List<E extends Comparable<E>> extends AbstractList<E> {
    /**
    * The add method does what the name suggests.
    * Add an int item to the array.
    * The assumption is to store the item at the end of the array
    * What is the end of the list?
    * Is it the same as the end of the listay?
    * Think about how you can use the size variable to add item
    * to the list.
    * The method returns void (nothing)
    * @param item element to be added.
    */
    public void add(final E item) {
        this.reSize();
        this.elements[this.size] = item;
        this.size = this.size + 1;
    }

     /**
     * Appends all of the elements in the specified array
     * to the end of this array.
     * @param items list containing elements to be added to this list.
     */
    public void addAll(final E[] items) {
        for (int i = 0; i < items.length; i++) {
            this.add(items[i]);
        }
    }
     /**
     * Appends all of the elements in the specified list
     * to the end of this list.
     * @param lst list containing elements to be added to this list.
     * @throws InvalidIndexException when index is not bounds.
     */
    public void addAll(final List<E> lst) throws InvalidIndexException {
        for (int i = 0; i < lst.size(); i++) {
            this.add(lst.get(i));
        }
    }
    
    /**
     * Given an index and an item, adds this item at a particular index.
     * Example:
     * Let's say for example the List object contains : [5,-2,3,1,6,-1]
     * Input : add(1, 2)
     * First Move all the elements to the right by
     * one upto the given index. So, you
     * will be having a gap at the given index where
     *  you can insert a new element / item
     * that is passed as parameter.
     * Output : [5,2,-2,3,1,6,-1]
     * Can you think of the following works:
     * Let's say for example the List object contains : [5,-2,3,1,6,-1]
     * Input: add(20, 2) : As there are 6 elements,
     *  you can't insert an element / item
     * after 6th index.
     * Output: [5,2,-2,3,1,6,-1]
     * @param index postion at which the element needs to be added.
     * @param item  the item that needs to be added.
     * @throws InvalidIndexException throws exception if index is not valid.
     */
    public void add(final int index, final E item)
        throws InvalidIndexException {
        if (index > this.size || index < 0) {
            throw new InvalidIndexException("index error");
        }
        this.reSize();
        E temp = this.elements[index];
        for (int i = index + 1; i < this.size; i++) {
            this.elements[i] = temp;
            temp = this.elements[i + 1];
        }
    }
}