class OrderedList<E extends Comparable<E>> extends AbstractList<E> {

    /**
    * The add method does what the name suggests.
    * Add an int item to the array.
    * The assumption is to store the item in the array such that
    * entire array is in sorted array.
    * The method returns void (nothing)
    * @param item element to be added.
    */
    public void add(final E item) {
        int position = -1;
        E temp = null;
        if (this.size == 0) {
            this.reSize();
            this.elements[this.size] = item;
            this.size = this.size + 1;
            return;
        }

        for (int i = 0; i < this.size; i++) {
            if (item.compareTo(this.elements[i]) <= 0) {
                temp = this.elements[i];
                position = i;
                break;
            }
        }
        if (position != -1) {
            this.reSize();
            for (int i = this.size; i > position; i--) {
                this.elements[i] = this.elements[i - 1];
            }
            this.elements[position] = item;
            this.size = this.size + 1;
        } else {
            this.reSize();
            this.elements[this.size] = item;
            this.size = this.size + 1;
        }
    }

    /**
     * Appends all of the elements in the specified array.
     * @param lst list containing elements to be added to this list.
     * @exception InvalidIndexException when unable to get the element of list .
     */
    public void addAll(final List<E> lst) throws InvalidIndexException {
        for (int i = 0; i < lst.size(); i++) {
            this.add(lst.get(i));
        }
    }

    /**
     * Appends all of the elements in the specified array.
     * @param items list containing elements to be added to this list.
     */
    public void addAll(final E[] items) {
        for (int i = 0; i < items.length; i++) {
            this.add(items[i]);
        }
    }
}