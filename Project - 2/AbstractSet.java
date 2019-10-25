public abstract class AbstractSet<E extends Comparable<E>> extends AbstractList<E> implements SetInterface<E> {

    public boolean isSubSet(Set<E> setA) {
        for (int i = 0; i < setA.size(); i++) {
            if (!this.contains((E) setA.list[i])) {
                return false;
            }
        }
        return true;
    }

    public Set<E> union(Set<E> setA) throws InvalidIndexException {
        Set<E> tempSet = new Set<E>();
        for (int i = 0; i < setA.size(); i++) {
            tempSet.add(setA.get(i));
        }
        for (int j = 0; j < this.size(); j++){
            tempSet.add(this.get(j));
        }
        return tempSet;
    }

    public Set<E> intersection(Set<E> setA) throws InvalidIndexException {
        Set<E> tempSet = new Set<E>();
        for (int i = 0; i < setA.size(); i++) {
            if(this.contains(setA.get(i))){
                tempSet.add(setA.get(i));
            }
        }
        return tempSet;
    }
}