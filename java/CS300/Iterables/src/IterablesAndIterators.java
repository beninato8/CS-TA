import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterablesAndIterators {
  public static void main(String[] args) {
    BadSet mySet = new BadSet(); //create an instance of a bad set
    mySet.add("a"); //add elements
    mySet.add("b");
    mySet.add("c");
    mySet.add("d");
    System.out.println("For each");
    for (String item : mySet) { //iterate over them with for each (implicitly calls the iterator methods)
      System.out.println(item);
    }
    
    System.out.println("Iterator");
    Iterator<String> it = mySet.iterator(); //same thing as for each
    while (it.hasNext())
    {
      System.out.println(it.next());
    }
  }
}


class BadSet implements Iterable<String> { //BadSet is iterable, so it must return an iterator object

  List<String> list;

  public BadSet() {
    list = new ArrayList<String>();
  }

  public void add(String s) {
    if (!list.contains(s))
      list.add(s);
  }

  public void remove(String s) {
    if (list.contains(s))
      list.remove(s);
  }

  public boolean contains(String s) {
    return list.contains(s);
  }

  @Override
  public Iterator<String> iterator() { //return an iterator for this object
    // TODO Auto-generated method stub
    return new FancyIterator();
  }

  class FancyIterator implements Iterator<String> { //iterator object must have hasNext and next (remove is optional)
    int idx = 0;
    @Override
    public boolean hasNext() {
      return list.size() >= idx + 1;
    }

    @Override
    public String next() {
      return list.get(idx++);
    }

    // optional method
    public void remove() {
      list.remove(idx);
    }

  }

}
