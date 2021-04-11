package containers;

import java.util.Iterator;
import java.util.ListIterator;

public class HybridList<E> {
  /**
   * underlying storage
   */
  private KWLinkedList<KWArrayList<E>> theData;
  private KWArrayList<E> refToCurrentArrayList;
  final private int MAX_NUMBER = 100;


  public HybridList() {
    theData = new KWLinkedList<KWArrayList<E>>();
    addNewArrayList();
  }

  public void add(E element) {
    if (refToCurrentArrayList.size() >= MAX_NUMBER) {
      addNewArrayList();
    }
    refToCurrentArrayList.add(element);
  }

  public E get(E element) {
    int index = indexOf(element);
    return index > -1 ? refToCurrentArrayList.get(index) : null;
  }

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

  public boolean remove(E element) {
    int index = indexOf(element);

    if (index > -1) {
      refToCurrentArrayList.remove(index);
      return true;
    }

    return false;
  }

  public int size() {

    return 0;
  }

  private void addNewArrayList() {
    refToCurrentArrayList = new KWArrayList<>(MAX_NUMBER);
    theData.addLast(refToCurrentArrayList);
  }

}
