package containers;

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
   * @return first occurence of element
   */
  public E get(E element) {
    int index = indexOf(element);
    return index > -1 ? refToCurrentArrayList.get(index) : null;
  }

  /**
   * @param element
   * @return index of element
   */
  public int indexOf(E element) {
    Iterator<KWArrayList<E>> iter = theData.listIterator();
    while(iter.hasNext()) {
      KWArrayList<E> arrayList = iter.next();
      int targetIndex = arrayList.indexOf(element);
      if (targetIndex > -1) {
        return targetIndex;
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

    if (index > -1) {
      refToCurrentArrayList.remove(index);

      if (refToCurrentArrayList.size() == 0) {
        theData.remove(refToCurrentArrayList);
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