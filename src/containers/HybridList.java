package containers;

import java.util.ListIterator;

public class HybridList<E> {
  /**
   * underlying storage
   */
  private KWLinkedList<KWArrayList<E>> theData;
  private ListIterator<KWArrayList<E>> iter;
  private KWArrayList<E> refToCurrentArrayList;
  final private int MAX_NUMBER = 100;


  public HybridList() {
    theData = new KWLinkedList<KWArrayList<E>>();
    theData.addFirst(new KWArrayList<>(MAX_NUMBER));
    iter = theData.listIterator();
    refToCurrentArrayList = iter.next();
  }

  public void add(E obj) {
    refToCurrentArrayList.add(obj);
  }

  public E get(int index) {

    return null;
  }

  public E getFirst() {
    return null;
  }

  public E getLast() {
    return null;

  }

  public boolean remove(E obj) {
    return true;
  }

  public int size() {
    return 0;
  }


}
