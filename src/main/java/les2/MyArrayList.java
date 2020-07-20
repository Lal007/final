package les2;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {

    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        data = (T[]) new Object[initialCapacity];
    }

    public MyArrayList() {
        this(10);
    }

    public void add(T value) {
        checkSize();
        data[size++] = value;
    }

    private void checkSize() {
        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
        }
    }

    public boolean remove(T value) {
        int index = indexOf(value);

        if (index != -1) {
            return removeByIndex(index) != null;
        }

        return false;
    }

    public T removeByIndex(int index) {
        T result = data[index];

        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null;
        return result;
    }

    private int indexOf(T value) {
        for (int i = 0; i < data.length; i++) {
            if (Objects.equals(value, data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value ) != -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
