class Set<E extends Comparable<E>> extends AbstractSet<E> {

    /**
    * The add method does what the name suggests.
    * Add an int item to the array.
    * first it checks if the item is present in the array or not.
    * if element is not present in the array then it adds into array.
    * The method returns void (nothing)
    * @param item element to be added.
    */
    public void add(final E item) {
        boolean notPresent = true;
        for (int i = 0; i < this.size; i++) {
            if (item.compareTo(this.elements[i]) == 0) {
                notPresent = false;
                break;
            }
        }
        if (notPresent) {
            this.reSize();
            this.elements[this.size] = item;
            this.size = this.size + 1;
        }
    }
    /**
    * The add method does what the name suggests.
    * Add an all the elemennts of list type E to the array.
    * first it checks if the item is present in the array or not.
    * if element is not present in the array then it adds into array.
    * The method returns void (nothing)
    * @param lst element to be added.
    * @exception InvalidIndexException when unbale to get an element of list
    */
    public void addAll(final List<E> lst) throws InvalidIndexException {
        int lstLen = lst.size();
        for (int i = 0; i < lstLen; i++) {
            this.add(lst.get(i));
        }
    }
    /**
    * The add method does what the name suggests.
    * Add an all the elemennts of array of type E to the array.
    * first it checks if the item is present in the array or not.
    * if element is not present in the array then it adds into array.
    * The method returns void (nothing)
    * @param items element to be added.
    */
    public void addAll(final E[] items) {
        for (int i = 0; i < items.length; i++) {
            this.add(items[i]);
        }
    }
    /**
    * The add method does what the name suggests.
    * Add an all the elemennts of list to the array.
    * first it checks if the item is present in the array or not.
    * if element is not present in the array then it adds into array.
    * The method returns void (nothing)
    * @param lst element to be added.
    * @exception InvalidIndexException when unbale to get an element of list
    */
    public void add(final List lst) throws InvalidIndexException {
        int lstLen = lst.size();
        for (int i = 0; i < lstLen; i++) {
            this.add((E) lst.get(i));
        }
    }
}