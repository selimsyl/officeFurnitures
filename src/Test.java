import containers.HybridList;
import containers.KWArrayList;
import containers.KWLinkedList;

import java.util.Iterator;
import java.util.List;

public class Test {

  public static void TestRun() {
    new KWLinkedListTest().run();
    new KWArrayListTest().run();
    new KWHybridListTest().run();
  }
  static private void printTestResult(String s) {
    System.out.println("TEST " + s);
  }
  public static class KWLinkedListTest {
    KWLinkedList<Integer> list = new KWLinkedList<Integer>();
    void run() {
      System.out.println("**************************KWLinkedListTest is Started**************************");
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
  }

  public static class KWArrayListTest {
    KWArrayList<Integer> list = new KWArrayList<Integer>();
    void run() {
      System.out.println("**************************KWArrayListTest is Started**************************");
      list.add(1);
      list.add(list.size(),2);
      list.add(0,3);
      list.add(42);
      list.add(4);

      if (searchItem(4, "in")) printTestResult("PASSED");
      else printTestResult("FAILED");

      if (searchItem(3, "in")) printTestResult("PASSED");
      else printTestResult("FAILED");

      if (!searchItem(333, "not in")) printTestResult("PASSED");
      else printTestResult("FAILED");

      if (!removeItem(545, "not in")) printTestResult("PASSED");
      else printTestResult("FAILED");

      if (removeItem(3, "in")) printTestResult("PASSED");
      else printTestResult("FAILED");
    }
      private  boolean searchItem(Integer item,String s) {
        System.out.println("Search item "+s+" list is started");
        for (int i = 0; i < list.size(); ++i) {
          if (list.get(i).equals(item)) {
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
        for (int i = 0; i < list.size(); ++i) {
          if (list.get(i).equals(item)) {
            list.remove(i);
            System.out.println("Find item index at : " + i);
            System.out.println("Remove item "+s+" list is end");
            return true;
          }
        }
        System.out.println("Remove item "+s+" list is end");
        return false;
      }
  }

  public static class KWHybridListTest {
      HybridList<Integer> list = new HybridList<Integer>();
      void run() {
        System.out.println("**************************HybridListTest is Started**************************");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(42);
        list.add(4);

        if (searchItem(4, "in")) printTestResult("PASSED");
        else printTestResult("FAILED");

        if (searchItem(3, "in")) printTestResult("PASSED");
        else printTestResult("FAILED");

        if (!searchItem(333, "not in")) printTestResult("PASSED");
        else printTestResult("FAILED");

        if (!removeItem(545, "not in")) printTestResult("PASSED");
        else printTestResult("FAILED");

        if (removeItem(3, "in")) printTestResult("PASSED");
        else printTestResult("FAILED");
      }
      private  boolean searchItem(Integer item,String s) {
        System.out.println("Search item "+s+" list is started");
        int targetIndex = list.indexOf(item);
        if (targetIndex != -1) {
          System.out.println("Find item index at : " + targetIndex);
          System.out.println("Search item "+s+" list is end");
          return true;
        }
        System.out.println("Search item "+s+" list is end");
        return false;
      }

      private  boolean removeItem(Integer item,String s) {
        System.out.println("Remove item "+s+" list is started");
        int targetIndex = list.indexOf(item);
        if (targetIndex != -1) {
          list.remove(list.get(targetIndex));
          System.out.println("Find item index at : " + targetIndex);
          System.out.println("Remove item "+s+" list is end");
          return true;
        }
        System.out.println("Remove item "+s+" list is end");
        return false;
      }
    }
}
