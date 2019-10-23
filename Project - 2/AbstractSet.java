abstract class AbstractSet<E extends Comparable<E>> extends AbstractList<E>
    implements SetInterface<E> {
    /**
    * checks if the given set is subset of current set.
    * @param s set of elements.
    * @return true or false
    */
    public boolean isSubSet(final Set<E> s) {
        int count = 0;
        for (int i = 0; i < s.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (s.elements[i].equals(this.elements[j])) {
                    count++;
                    break;
                }
            }
        }
        if (count == s.elements.length) {
            return true;
        }
        return false;
    }
    /**
    * creats a new array by combining the setA and current set.
    * @param setA elements.
    * @return elelemts of type set
    */
    public Set<E> union(final Set<E> setA) {
        Set<E> newSet = new Set<E>();
        for (int i = 0; i < this.size; i++) {
            newSet.add(this.elements[i]);
        }
        for (int i = 0; i < setA.size; i++) {
            newSet.add(setA.elements[i]);
        }
        return newSet;
    }
    /**
    * creats a new array by combining the common elements of setA
    * and current set.
    * @param setA elements.
    * @return elelemts of type set
    */
    public Set<E> intersection(final Set<E> setA) {
        Set<E> newSet = new Set<E>();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < setA.size; j++) {
                if (this.elements[i].equals(setA.elements[j])) {
                    newSet.add(setA.elements[j]);
                    break;
                }
            }
        }
        return newSet;
    }
}