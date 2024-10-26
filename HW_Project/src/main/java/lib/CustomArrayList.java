package lib;

import interfaces.IList;

import java.util.*;

public class CustomArrayList<E> implements IList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int lastIndex;

    public CustomArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }
    public CustomArrayList(int capacity) {
        data = new Object[capacity];
    }


    @Override
    public E get(int index) {
        if (index < 0 || index >= lastIndex){
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
    }

    @Override
    public void add(E element) {
        if (lastIndex == data.length){
            grow();
        }
        data[lastIndex++] = element;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        if (lastIndex == data.length){
            grow();
        }
        data[index] = element;
    }
    //???
    @Override
    public void addAll(Collection<? extends E> c) {
        Object[] addData = c.toArray();
        for (int i = 0; i < addData.length; i++) {
            add((E)addData[i]);
        }
    }

    @Override
    public E remove(int index) {
        E element =(E)data[index];
        moveTailLeft(index);
        lastIndex--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        int count = 0;
        Object[] newArray = new Object[data.length];
        int position = 0;

        for (int i = 0; i < lastIndex; i++){
            if (data[i].equals(o)) {
                count++;
                continue;
            }
            newArray[position++] = data[i];
        }
        data = newArray;
        lastIndex=position;
        return count==0 ? false : true;
    }

    @Override
    public void clear() {
        for (int to = lastIndex, i = lastIndex = 0; i < to; i++){
            data[i] = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        downMergeSort((E[]) data,0, lastIndex-1, c);
    }







    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<E>{
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != lastIndex;
        }

        @Override
        public E next() {
            if (cursor >= lastIndex){
                throw new NoSuchElementException();
            }
            return (E) data[cursor++];
        }
    }

    private void grow() {
        int newCapacity = data.length * 2;
        this.data = Arrays.copyOf(data, newCapacity);
    }

    private void moveTailLeft(int index) {
        for (int i = index; i <lastIndex; i++) {
            data[i] = data[i+1];
        }
    }

    private <E> void downMergeSort(E[] array,int left,int right, Comparator<? super E> c){
        if (left < right) {
            int mid = (left + right) / 2;
            downMergeSort(array, left, mid,c);
            downMergeSort(array, mid + 1, right,c);
            merge(array, left, mid, right,c);
        }
    }

    private <E> void  merge(E[] array, int start, int middle, int end, Comparator<? super E> c) {

        E[] leftPart = Arrays.copyOfRange(array, start, middle+1);
        E[] rightPart = Arrays.copyOfRange(array, middle+1, end+1);

        int i, j, k;
        i = 0;
        j = 0;
        k = start;

        while (i < leftPart.length && j < rightPart.length) {
            if ((c.compare(leftPart[i], rightPart[j])) <= 0) {
                array[k] = leftPart[i];
                i++;
            } else {
                array[k] = rightPart[j];
                j++;
            }
            k++;
        }
        while (i < leftPart.length) {
            array[k] = leftPart[i];
            i++;
            k++;
        }
        while (j < rightPart.length) {
            array[k] = rightPart[j];
            j++;
            k++;
        }

    }

}
