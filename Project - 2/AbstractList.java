abstract class AbstractList<E extends Comparable<E>> implements ListInterface<E>{
    E[] list;
    int size;
    /**
     * 
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
     * 
     */
    public E get(int index) throws InvalidIndexException{
        if (index < 0 || index >=size){
            throw new InvalidIndexException("Index exception Error");
        }
        return list[index];
    }
    /**
     * 
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
     * 
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
     * 
     */
    public int size() {
        return size;
    }
    /**
     * 
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
     * 
     * @param item
     * @return
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
     * 
     * @param item
     * @return
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
     * 
     */
    public void set(int index, E item){
        if (index <= size){
            list[index] = item;
        }
    }
    /**
     * 
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
     * 
     * @param items
     */
    public void addAll(E[] items){
        for (int i = 0; i < items.length; i++){
            this.add(items[i]);
        }
    }
    public void addAll(List<E> lst) throws InvalidIndexException {
        for (int i = 0; i < lst.size(); i++){
            this.add(lst.get(i));
        }
    }
}