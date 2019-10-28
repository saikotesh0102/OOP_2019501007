public abstract class AbstractSet<E extends Comparable<E>> extends AbstractList<E> implements SetInterface<E> {
    /**
     * Method to check whether a set is subset of main set
     * @param setA
     * @return true or false
     */
    public boolean isSubSet(Set<E> setA) {
        for (int i = 0; i < setA.size(); i++) {
            if (!this.contains((E) setA.list[i])) {
                return false;
            }
        }
        return true;
    }
    /**
     * Method to write union of two sets
     * @param setA
     * @return Set of union elements
     * @throws InvalidIndexException
     */
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
    /**
     * Method to write intersection of two sets
     * @param setA
     * @return Set of intersection elements
     * @throws InvalidIndexException
     */
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