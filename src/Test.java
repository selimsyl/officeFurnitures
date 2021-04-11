import containers.KWLinkedList;

import java.util.List;

public class Test {

  public static class KWLinkedListTest {
    static void run() {
      KWLinkedList<Integer> list = new KWLinkedList<Integer>();
      list.addFirst(1);
      list.addLast(2);
      list.addLast(3);
      list.addFirst(42);
      list.addLast(4);

      printList(list);

      list.remove(1);
      printList(list);

      list.remove(2);
      printList(list);

      list.remove(3);
      printList(list);

      list.remove(4);
      printList(list);

      list.addFirst(7);
      printList(list);
      list.addLast(31);
      list.addLast(52);
      list.addLast(21);
      list.addLast(99);
      printList(list);
      list.remove(52);
      list.remove(21);
      printList(list);
      if(!list.remove(47)) {
        System.out.print("there is no 47 in the list");
      }
    }
    private static void printList(KWLinkedList list) {
      for (int i = 0; i < list.size(); ++i) {
        System.out.print(list.get(i) + " ");
      }
      System.out.println();
    }
  }

  public static class KWArrayListTest {
    static void run() {

    }
  }

  public static class KWHybridListTest {
    static void run() {

    }
  }

}
