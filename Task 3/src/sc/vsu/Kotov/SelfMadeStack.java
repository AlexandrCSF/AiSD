package sc.vsu.Kotov;

// Сделано на основе Стека, который делал Дмитрий Соломатин на лекции
public class SelfMadeStack<T> extends SimplifiedLinkedList<T> {
    public void push(T value) {
        addFirst(value);
    }

    public T pop() throws SimplifiedLinkedListExeption {
        emptyError();
        T result = get(getSize() - 1);
        removeLast();
        return result;
    }

    public boolean empty() {
        return getSize() == 0;
    }

    public T peek() {
        return get(getSize());
    }

    public int search(T value) {
        for (int i = 0; i < getSize(); i++) {
            if (getValue(i) == value) {
                return i;
            }
        }
        return -1;
    }
}
