public class Test{
    public static void main(String[] args) throws InvalidIndexException {
        List<String> stringList = new List<String>();
        stringList.add("itemlist1");
        stringList.add("itemlist2");
        stringList.add("itemlist3");
        stringList.add("itemlist3");
        OrderedList<String> stringList1 = new OrderedList<String>();
        stringList1.add("itemorderedlist1");
        stringList1.add("itemorderedlist2");
        stringList1.add("itemorderedlist3");
        stringList1.add("itemorderedlist3");
        stringList1.add("itemorderedlist3");
        Set<String> stringSet = new Set<String>();
        stringSet.add("itemSet1");
        stringSet.add("itemSet2");
        stringSet.add("itemSet3");
        stringSet.add("itemSet3");
        OrderedSet<String> stringSet1 = new OrderedSet<String>();
        stringSet1.add("itemOrderedSet1");
        stringSet1.add("itemOrderedSet2");
        stringSet1.add("itemOrderedSet3");
        stringSet1.add("itemOrderedSet3");
        stringSet1.add("itemOrderedSet3");
        System.out.println(stringList.get(2));
        Set<String> StringSet2 = new Set<String>();
        StringSet2 = stringSet.union(stringSet);
        System.out.println(stringSet.toString());
        StringSet2 = stringSet.intersection(stringSet);
        System.out.println(StringSet2.toString());
        System.out.println(stringSet.isSubSet(StringSet2));
        StringSet2.addAll(stringList);
        System.out.println(StringSet2.toString());
    }
}