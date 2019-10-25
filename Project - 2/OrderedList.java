public class OrderedList<E extends Comparable<E>> extends AbstractList<E> {
    public OrderedList(){
        this.list = (E[]) new Comparable[10];
        this.size =0;
    }
    
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
    
    public void addAll(List<E> lst) throws InvalidIndexException {
        for (int i = 0; i < lst.size(); i++){
            this.add(lst.get(i));
        }
    }
    
    private void rearrange(int i, E temp) {
        for (int j = i + 1; j < size - 1; j++) {
            list[j] = temp;
            temp = list[j + 1];
        }
    }
}