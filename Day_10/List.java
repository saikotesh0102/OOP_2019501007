public class List extends AbstractList {
    
    public final void add(int index, int item) {
        // TODO
        // Your code goes here.
        if(index > 0 && index > size){
            resize();
            list[size] = item;
        }else if(index > 0 && index < size){
            for (int i = size; i > index; i--){
                list[i] = list[i-1];
            }
            list[index] = item;
        }
    }

    public void addAll(List lst) {
        // TODO
        // Your code goes here.
        resize();
        int index = size;
        for(int i = 0; i < lst.length; i++){
            list[index++] = this.lst[i];
        }
    }

    public void addAll(int[] arr ){
        // TODO
        // Your code goes here.
        if((list.length - size) < arr.length){
            resize();
            int index = size;
            for(int i = 0; i < arr.length; i++){
                list[index++] = arr[i];
            }
        }else{
            int index = size;
            for(int i = 0; i < arr.length; i++){
                list[index++] = arr[i];
            }
        }
    }
}