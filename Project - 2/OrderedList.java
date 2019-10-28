public class OrderedList<E extends Comparable<E>> extends AbstractList<E> {
    /**
     * Constructor
     */
    public OrderedList(){
        this.list = (E[]) new Comparable[10];
        this.size =0;
    }
    /**
     * Method to add an item to a list
     * @param item
     */
    public void add(E item) {
        if (size == list.length) {
            resize();
        }
        if (size == 0){
            list[size] = item;
            size += 1;
        }else{
            for (int i = 0; i < size; i++) {
                if (item.compareTo(list[i]) <= 0) {
                    E temp = list[i];
                    list[i] = item;
                    rearrange(i, temp);
                    break;
                }
            }
            list[size] = item;
            size += 1;
        }
    }
    /**
     * Method to addall items to a list
     * @param lst
     * @throws InvalidIndexException
     */
    public void addAll(List<E> lst) throws InvalidIndexException {
        for (int i = 0; i < lst.size(); i++){
            this.add(lst.get(i));
        }
    }
    /**
     * Method to rearrange elements
     * @param i
     * @param temp
     */
    private void rearrange(int i, E temp) {
        for (int j = i + 1; j < size - 1; j++) {
            list[j] = temp;
            temp = list[j + 1];
        }
    }
}