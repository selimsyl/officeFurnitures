package containers;

import java.util.*;

public class KWLinkedList<E> {

    /**
     * reference to first node
     */
    private Node<E> head;
    /**
     * reference last node
     */
    private Node<E> tail;
    /**
     * size of list
     */
    private int size;

    public KWLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @param index  position to insert element
     * @param element element to be inserted
     */
    public void add(int index, E element) {
        listIterator(index).add(element);
    }

    /**
     * @param element element to be inserted
     */
    public void addFirst(E element) {
        add(0,element);
    }

    /**
     * @param element element to be inserted
     */
    public void addLast(E element) {
        add(size,element);
    }

    /**
     * @param index get element of index
     * @return element
     */
    public E get(int index) {
        return listIterator(index).next();
    }

    /**
     * @return first element in list
     */
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.data;
    }

    /**
     * @return last element in list
     */
    public E getLast() {
        if (tail == null)
            throw new NoSuchElementException();
        return tail.data;
    }

    /**
     * @param element to be removed
     * @return true if element exists
     */
    public boolean remove(E element) {
        ListIterator<E> iter = listIterator();
        while(iter.hasNext()) {
            if (iter.next().equals(element)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * @return size of list
     */
    public int size() {
        return size;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public ListIterator<E> listIterator() {
        return new KWListIter();
    }

    public ListIterator<E> listIterator(int index) {
        return new KWListIter(index);
    }

    private class KWListIter implements ListIterator<E> {
        /**
         * reference next node
         */
        private Node<E> nextItem;
        /**
         * reference to last jumped over node
         */
        private Node<E> lastItemReturned;
        /**
         * index of current node
         */
        private int index;

        KWListIter() {
            nextItem = head;
            lastItemReturned = null;
            index = 0;
        }

        /**
         * @param i element in the list
         */
        KWListIter(int i) {
            checkIndexBorder(i);

            lastItemReturned = null;

            if (i == size) {
                index = size;
                nextItem = null;
            }
            else {
                nextItem = head;
                for (index = 0; index < i; ++index) {
                    nextItem = nextItem.next;
                }
            }
        }

        /**
         * @return true if there is a next node
         */
        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        /**
         * @return next node data
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /**
         * @return true if there is a previous node
         */
        @Override
        public boolean hasPrevious() {
            return nextItem != head;
        }

        /**
         * @return previous node data
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            if (nextItem == null) {
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }

            lastItemReturned = nextItem.prev;
            index--;
            return lastItemReturned.data;
        }

        @Override
        public void add(E e) {
            if (head == null) {
                head = new Node<>(e);
                tail = head;
            } else if(nextItem == head) {
                Node<E> newNode = new Node<E>(e);
                newNode.next = nextItem;
                nextItem.prev = newNode;
                head = newNode;
            } else if (nextItem == null) {
                Node<E> newNode = new Node<E>(e);
                tail.next = newNode;
                tail.next.prev = tail;
                tail = tail.next;
            } else {
                Node<E> newNode = new Node<E>(e);
                nextItem.prev.next = newNode;
                newNode.prev = nextItem.prev;
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            index++;
            size++;
            lastItemReturned = null;
        }

        @Override
        public void set(E e) {
            if (lastItemReturned == null)
                throw new IllegalStateException();
            lastItemReturned.data = e;
        }

        @Override
        public void remove() {
            if (lastItemReturned == null)
                throw new IllegalStateException();

            if (lastItemReturned == nextItem) {
                nextItem = lastItemReturned.next;
            }

            if (lastItemReturned == head) {//head of list
                head = nextItem;
                if (hasNext()) {
                    nextItem.prev = null;
                }
            } else if (!hasNext()) { //end of list
                lastItemReturned.prev.next = null;
                tail = lastItemReturned.prev;
            } else {
                nextItem.prev = lastItemReturned.prev;
                lastItemReturned.prev.next = nextItem;
            }
            index--;
            size--;
            lastItemReturned = null;
        }

        @Override
        public int nextIndex() {
            if (!hasNext())
                return size;
            return index;
        }

        @Override
        public int previousIndex() {
            if (!hasPrevious())
                return -1;
            return index-1;
        }

        private void checkIndexBorder(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException(index);
            }
        }
    }

    private static class Node<E> {
        /**
         * reference to data
         */
        private E data;
        /**
         * reference to next node
         */
        private Node<E> next = null;

        /**
         * reference to previous node
         */
        private Node<E> prev = null;

        /**
         * Creates a new node with a null next field.
         * @param element The data stored
         */
        private Node(E element) {
            data = element;
            next = null;
            prev = null;
        }
    }
}
