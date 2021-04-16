package containers;

import officeFurnitures.Product;

import java.util.Iterator;
import java.util.ListIterator;

public class HybridList<E> {
  /**
   * underlying storage
   */
  private KWLinkedList<KWArrayList<E>> theData;
  /**
   * reference to current arrayList to add elements
   */
  private KWArrayList<E> refToCurrentArrayList;
  /**
   * max lenghth of stored arrayLists
   */
  final private int MAX_NUMBER = 100;

  /**
   * initialize hybrid list
   */
  public HybridList() {
    theData = new KWLinkedList<KWArrayList<E>>();
    addNewArrayList();
  }

  /**
   * @param element to be added end of hybridList
   */
  public void add(E element) {
    if (refToCurrentArrayList.size() >= MAX_NUMBER) {
      addNewArrayList();
    }
    refToCurrentArrayList.add(element);
  }

  /**
   * @param element to returned
   * @return first occurence of element, otherwise null
   */
  public E get(E element) {
    int index = indexOf(element);

    return index > -1 ? get(index) : null;
  }

  /**
   * @param index target element index
   * @return target element
   */
  public E get(int index) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException(index);
    }
    int arrayListIndex = index / MAX_NUMBER;
    int elementIndex = index % MAX_NUMBER;

    return theData.listIterator(arrayListIndex).next().get(elementIndex);
  }

  /**
   * @param element
   * @return index of element
   */
  public int indexOf(E element) {
    ListIterator<KWArrayList<E>> iter = theData.listIterator();
    while(iter.hasNext()) {
      KWArrayList<E> arrayList = iter.next();
      int targetIndex = arrayList.indexOf(element);
      if (targetIndex > -1) {
        return targetIndex + (iter.nextIndex()-1) * MAX_NUMBER;
      }
    }
    return -1;
  }

  /**
   * @param element to be removed
   * @return true if element is exists and removed,
   * otherwise false
   */
  public boolean remove(E element) {
    int index = indexOf(element);

    int arrayListIndex = index / MAX_NUMBER;
    int elementIndex = index % MAX_NUMBER;

    if (index > -1) {
      KWArrayList<E> tempCurrentArrayList = theData.listIterator(arrayListIndex).next();
      tempCurrentArrayList.remove(elementIndex);

      if (tempCurrentArrayList.size() == 0) {
        theData.remove(tempCurrentArrayList);
        refToCurrentArrayList = theData.getLast();
      }
      return true;
    }

    return false;
  }

  /**
   * @return numbers of stored elements
   */
  public int size() {
    return (theData.size()-1)*MAX_NUMBER + refToCurrentArrayList.size();
  }

  private void addNewArrayList() {
    refToCurrentArrayList = new KWArrayList<>(MAX_NUMBER);
    theData.addLast(refToCurrentArrayList);
  }

}
