public abstract class AbstractList<E extends Comparable<E>> implements ListInterface<E>{
    E[] list;
    int size;
    /**
     * Method to resize the array of type E
     */
    public void resize() {
        E[] tempArray = (E[]) new Comparable[size * 2];
        for (int i = 0; i < size; i++){
            tempArray[i] = list[i];
        }
        list = null;
        list = tempArray;
        tempArray = null;
    }
    /**
     * To get the element at that particular index
     * @param index
     * @return element at that index
     * @throws InvalidIndexException
     */
    public E get(int index) throws InvalidIndexException{
        if (index < 0 || index >=size){
            throw new InvalidIndexException("Index exception Error");
        }
        return list[index];
    }
    /**
     * Method to check whether the element is present or not in the list
     * @param item
     * @return true or false
     */
    public boolean contains(E item) {
        for (int i = 0; i < size; i++){
            if (item.compareTo(list[i]) == 0){
                return true;
            }
        }
        return false;
    }
    /**
     * Method to remove an element at a particular index
     * @param index
     * @throws InvalidIndexException
     */
    public void remove(int index) throws InvalidIndexException{
        if (index >= size || index < 0){
            throw new InvalidIndexException("Index exception Error");
        }
        for(int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            list[size] = null;
            size -= 1;
    }
    /**
     * Method to return the size
     * @return Size
     */
    public int size() {
        return size;
    }
    /**
     * Method to return a particular item at a particular index
     * @param item
     * @return index of a particular item 
     */
    public int indexOf(E item) {
        for (int i = 0; i < size; i++){
            if (item.compareTo(list[i]) == 0){
                return i;
            }
        }
        return -1;
    }
    /**
     * Method to return last index of the particular element
     * @param item
     * @return index of the last item in the list
     */
    public int lastIndexOf(E item){
        if (this.contains(item)){
            for (int i = size -1; i>=0; i--) {
                if(item.compareTo(list[i]) == 0){
                    return i;
                }
            }
        } 
        return -1;
    }
    /**
     * Method to return the count of a particular element
     * @param item
     * @return no of times the element 
     */
    public int count(E item){
        int times = 0;
        for (int i =0; i < size; i++){
            if (item.compareTo(list[i]) == 0){
                times +=1;
            }
        }
        return times;
    }
    /**
     * To String method 
     */
    public String toString() {
        if(size == 0) {
            return "empty";
        }
        StringBuffer str = new StringBuffer();
        str.append("[");
        int i = 0;
        for(i = 0; i < size - 1; i++) {
            str.append(list[i] + ",");
        }
        str.append(list[size - 1] + "]");
        return str.toString();
    }
    /**
     * Method to set an element at a particular index
     * @param index
     * @param item
     */
    public void set(int index, E item){
        if (index <= size){
            list[index] = item;
        }
    }
    /**
     * Method to return a sublist from index to to index
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public List<E> subList(int fromIndex, int toIndex){
        List<E> tempList = new List<E>();
        if (fromIndex < size && toIndex <=size && fromIndex >= 0 && toIndex > 0){
            for (int i = fromIndex; i < toIndex; i++){
                tempList.add(list[i]);
            }
            return tempList;
        }
        return null;
    }
    /**
     * Method to add all items to the list
     * @param items
     */
    public void addAll(E[] items){
        for (int i = 0; i < items.length; i++){
            this.add(items[i]);
        }
    }
    /**
     * Method to add a list to another list 
     * @param lst
     * @throws InvalidIndexException
     */
    public void addAll(List<E> lst) throws InvalidIndexException {
        for (int i = 0; i < lst.size(); i++){
            this.add(lst.get(i));
        }
    }
}