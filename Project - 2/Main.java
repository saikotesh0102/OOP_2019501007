class Main {
    public static void main(String[] args) throws Exception{
        try {
            Set<Integer> setElements = new Set<Integer>();
            setElements.add(new Integer(36));
            setElements.add(new Integer(95));
            setElements.add(new Integer(31));
            setElements.add(new Integer(93));
            List<Integer> newList = new List<>();
            newList.add(new Integer(69));
            newList.add(29);
            newList.add(36);
            setElements.add(newList);
            System.out.println(" get " + setElements.get(5));
            System.out.println(" index " + setElements.indexOf(29));
            System.out.println(" contains " + setElements.contains(93));
            // System.out.println(" contains " + setElements.remove(93));
            setElements.remove(1);
            Set<Integer> tempSet = new Set<Integer>();
            tempSet.add(new Integer(192));
            tempSet.add(new Integer(879));
            tempSet.add(69);
            tempSet.add(36);

            
            System.out.println(" subset " + setElements.isSubSet(tempSet));

            Set un = setElements.union(tempSet);
            Set in = setElements.intersection(tempSet);


            for (int i = 0; i < in.size; i++) {
                System.out.println(in.get(i));
            }

            System.out.println("--------------------------------------------");
            OrderedSet<Integer> orderedSetElements = new OrderedSet<Integer>();
            orderedSetElements.add(new Integer(36));
            orderedSetElements.add(new Integer(95));
            orderedSetElements.add(new Integer(31));
            orderedSetElements.add(new Integer(93));
            List<Integer> tempList = new List<>();
            tempList.add(new Integer(69));
            tempList.add(29);
            tempList.add(36);
            orderedSetElements.add(newList);
            for (int i = 0; i < orderedSetElements.size; i++) {
                System.out.println(orderedSetElements.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " hello ");
        }
        
        List<Integer> ls = new List<Integer>();
        ls.add(new Integer(36));
        ls.add(new Integer(95));
        ls.add(new Integer(31));
        ls.add(new Integer(93));
        List<Integer> newList = new List<Integer>();
        newList.add(new Integer(69));
        newList.add(29);
        newList.add(36);
        ls.addAll(newList);
        for (int i = 0; i < ls.size; i++) {
            System.out.println(ls.get(i));
        }
        OrderedList<Integer> lis = new OrderedList<Integer>();
        lis.add(new Integer(36));
        lis.add(new Integer(95));
        lis.add(new Integer(31));
        lis.add(new Integer(93));
        List<Integer> newLis = new List<Integer>();
        newLis.add(new Integer(69));
        newLis.add(29);
        newLis.add(36);
        lis.addAll(newList);
        System.out.println("----------------");
        for (int i = 0; i < ls.size; i++) {
            System.out.println(ls.get(i));
        }
    }
}