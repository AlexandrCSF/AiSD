package sc.vsu.Kotov;
// Сделано на основе связного списка, который делал Дмитрий Соломатин на лекции
public class SimplifiedLinkedList<T> {

    public static class SimplifiedLinkedListExeption extends Exception {
        public SimplifiedLinkedListExeption(String message) {
            super(message);
        }
    }

    private class SimplifiedLinkedListNode {
        public T value;
        public SimplifiedLinkedListNode next;

        public SimplifiedLinkedListNode(T value, SimplifiedLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimplifiedLinkedListNode(T value) {
            this(value, null);
        }

        public void setValue(T value) {
            this.value = value;
        }
    }


    private SimplifiedLinkedListNode head = null;
    private SimplifiedLinkedListNode tail = null;
    private int size = 0;


    public void addFirst(T value) {
        head = new SimplifiedLinkedListNode(value, head);

        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T value) {
        if (size == 0) {
            head = tail = new SimplifiedLinkedListNode(value);
        } else {
            tail.next = new SimplifiedLinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    void emptyError() throws SimplifiedLinkedListExeption {
        if (size == 0) {
            throw new SimplifiedLinkedListExeption("Empty list");
        }
    }

    public void removeFirst() throws SimplifiedLinkedListExeption {
        emptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    private SimplifiedLinkedListNode getNode(int index) {
        assert (index <= size);
        SimplifiedLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T getValue(int index) {
        return getNode(index).value;
    }


    public void set(int index, T value) {
        getNode(index).setValue(value);
    }

    public void removeLast() throws SimplifiedLinkedListExeption{
        emptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }

    public T get(int index) {
        return  getNode(index).value;
    }

    public int getSize() {
        return size;
    }
}
