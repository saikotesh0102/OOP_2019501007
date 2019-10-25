public class OrderedSet<E extends Comparable<E>> extends AbstractSet<E> {

    public OrderedSet(){
        this.list = (E[]) new Comparable[10];
        this.size =0;
    }

    private void rearrange(int i, E temp) {
        for (int j = i + 1; j < size - 1; j++) {
            list[j] = temp;
            temp = list[j + 1];
        }
    }

    @Override
    public void add(E item) {
        if (!this.contains(item)){
            if (size == list.length) {
                resize();
            }
            if (size == 0){
                list[size] = item;
                size += 1;
            }else{
                for (int i =0; i < size; i++) {
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
    }
}