public class Set<E extends Comparable<E>> extends AbstractSet<E>{
    public Set(){
        this.list = (E[]) new Comparable[10];
        this.size =0;
    }
    @Override
    public void add(E item) {
        if (!this.contains(item)){
            if (size == list.length) {
            resize();
        }
        list[size] = item;
        size += 1;
        }
    }
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