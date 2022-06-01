package ru.vsu.cs.course1;


public class Sort {

    public static SimplifiedLinkedList<Integer> sortLinkedList(SimplifiedLinkedList<Integer> list) {

        int j;
        int key;
        for (int i = 1; i < list.getSize(); i++) {
            j = i - 1;
            key = list.get(i);
            while (j > -1 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j+1,key);
        }
        return list;
    }
}
