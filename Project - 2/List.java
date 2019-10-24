class List<E extends Comparable<E>> extends AbstractList<E> {
    public List(){
        this.list = (E[]) new Comparable[10];
        this.size =0;
    }
    /**
     * 
     */
    public void add(E item) {
        if (size == list.length) {
            resize();
        }
        list[size] = item;
        size += 1;
    }
    
    /**
     * 
     * @param index
     * @param item
     */
    public void add(int index, E item) throws InvalidIndexException {
        if (index < size && index >=0){
            E temp2;
            E temp = list[index]; 
            list[index] = item;
            for (int j = index + 1; j < size +2; j++) {
                temp2 = list[j];
                list[j] = temp;
                temp = temp2;
                }
            size += 1;
        }
    }
}