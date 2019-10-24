public interface SetInterface<E extends Comparable<E>> {
    public Set<E> union(Set<E> setA) throws InvalidIndexException;
    public Set<E> intersection(Set<E> setA) throws InvalidIndexException;
    public boolean isSubSet(Set<E> setA) throws InvalidIndexException;
}