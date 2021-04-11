import containers.KWArrayList;
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
      KWArrayList<Integer> list = new KWArrayList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(42);
      list.add(4);

      printList(list);

      try {
        list.remove(1);
        printList(list);

        list.remove(2);
        printList(list);

        list.remove(3);
        printList(list);

        list.remove(0);
        printList(list);

        list.add(7);
        printList(list);
        list.add(31);
        list.add(52);
        list.add(21);
        list.add(99);
        printList(list);
        list.remove(list.size()-1);
        list.remove(list.size()-3);
        printList(list);
        list.remove(0);
        printList(list);

      } catch (Exception e) {
        System.out.print(e.getMessage());
      }
    }
    private static void printList(KWArrayList list) {
      for (int i = 0; i < list.size(); ++i) {
        System.out.print(list.get(i) + " ");
      }
      System.out.println();
    }
  }

  public static class KWHybridListTest {
    static void run() {

    }
  }

}
