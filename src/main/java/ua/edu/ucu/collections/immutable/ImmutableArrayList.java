package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {

    private int size;
    private Object[] arr;

    public ImmutableArrayList() {
        this.arr = new Object[0];
        this.size = 0;
    }

    public ImmutableArrayList(Object[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
        this.size = arr.length;
    }

    //додає елемент у кінець колекції
    @Override
    public ImmutableArrayList add(Object e) {
        return this.add(this.size, e);
    }

    // додає елемент до колекції за індексом, та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції
    @Override
    public ImmutableArrayList add(int index, Object e) {
        return this.addAll(index, new Object[]{e});
    }

    //додає масив елементів у кінець колекції
    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(this.size, c);
    }

    // додає масив елементів починаючи з зазначеного індекса, та кидає виключну
    // ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[this.size + c.length];
        System.arraycopy(this.arr, 0, newArr, 0, index);
        System.arraycopy(c, 0, newArr, index, c.length);
        if (index < this.size) {
            System.arraycopy(this.arr, index, newArr, index  + c.length,
                    this.size - index);
        }
        return new ImmutableArrayList(newArr);
    }

    //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс
    // виходить за межі колекції
    @Override
    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.arr[index];
    }

    //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс
    // виходить за межі колекції
    @Override
    public ImmutableArrayList remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[this.size-1];
        System.arraycopy(this.arr, 0, newArr, 0, index);
        System.arraycopy(this.arr, index + 1, newArr, index,
                this.size - index - 1);
        return new ImmutableArrayList(newArr);
    }

    //змінює значення елементу за індексом, та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції
    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[this.size];
        System.arraycopy(this.arr, 0, newArr, 0, index);
        newArr[index] = e;
        System.arraycopy(this.arr, index + 1, newArr, index + 1,
                this.size - index - 1);
        return new ImmutableArrayList(newArr);
    }

    //шукає індекс елемента (повертає індекс першого який знайшов,
    // або -1 у випадку відсутності)
    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //розмір колекції
    @Override
    public int size() {
        return this.size;
    }

    //очищує вміст колекції
    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    //якщо у колеції нема елементів то повертає true
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    //перетворює колекцію до масиву обєктів
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.size);
    }

    //повертає рядок, де через кому відображаютсься елементи колекції
    @Override
    public String toString() {
        return Arrays.toString(this.arr);
    }
}
