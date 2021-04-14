import containers.KWArrayList;
import containers.KWLinkedList;

import java.util.Iterator;
import java.util.List;

public class Test {

  public static void TestRun() {
    new KWLinkedListTest().run();
  }

  public static class KWLinkedListTest {
    KWLinkedList<Integer> list = new KWLinkedList<Integer>();
    void run() {
      list.addFirst(1);
      list.addLast(2);
      list.addLast(3);
      list.addFirst(42);
      list.addLast(4);

      if(searchItem(4,"in")) printTestResult("PASSED");
      else printTestResult("FAILED");

      if(searchItem(3,"in")) printTestResult("PASSED");
      else printTestResult("FAILED");

      if(!searchItem(333,"not in")) printTestResult("PASSED");
      else printTestResult("FAILED");

      if(!removeItem(545,"not in")) printTestResult("PASSED");
      else printTestResult("FAILED");

      if(removeItem(3,"in")) printTestResult("PASSED");
      else printTestResult("FAILED");

    }

    private  boolean searchItem(Integer item,String s) {
      System.out.println("Search item "+s+" list is started");
      Iterator<Integer> iter = list.listIterator();
      while(iter.hasNext()) {
        Integer i = iter.next();
        if (i.equals(item)) {
          System.out.println("Find item index at : " + i);
          System.out.println("Search item "+s+" list is end");
          return true;
        }
      }
      System.out.println("Search item "+s+" list is end");
      return false;
    }

    private  boolean removeItem(Integer item,String s) {
      System.out.println("Remove item "+s+" list is started");
      Iterator<Integer> iter = list.listIterator();
      while(iter.hasNext()) {
        Integer i = iter.next();
        if (i.equals(item)) {
          list.remove(i);
          System.out.println("Remove item index at : " + i);
          System.out.println("Remove item "+s+" list is end");
          return true;
        }
      }
      System.out.println("Remove item "+s+" list is end");
      return false;
    }

    private  void printList(KWLinkedList list) {
      for (int i = 0; i < list.size(); ++i) {
        System.out.print(list.get(i) + " ");
      }
      System.out.println();
    }
    private void printTestResult(String s) {
      System.out.println("TEST " + s);
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
