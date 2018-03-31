//Characters
//another example script
import java.util.Arrays;

class Anag{
  Node first;
  private class Node{
     String order;
     String item;
     Node next;
  }
 Anag()
   {
      first = null;
   }
 void push (String item)
  {
    Node newNode = new Node();
    newNode.item = item;
    char[] tmp = item.toCharArray();
    Arrays.sort(tmp);
    newNode.order = String.valueOf(tmp);
    newNode.next =null;
    if (first == null)
     {
       first  = newNode;
     }
    else
     {
       Node p = first;
       while (p.next != null)
        {
          if (p.order.compareTo(newNode.order) == 0)
            {
              newNode.next = p.next;
              p.next = newNode;
              break;
            }
          p = p.next;
        }
       if (p.next == null)
        {
           p.next = newNode;
        }
     }
  }

 void print()
  {
    Node p = first;
    while (p != null)
      {
        System.out.print(p.item + ", ");
        p = p.next;
      }
    System.out.println();
  }

}

public class test4<key, value>
{

  public static void main(String[] args)
  {
    //sample of words
    String wordArr[] = {"cat", "dog", "tac", "god", "cta"};
    Anag a = new Anag();
    for(int i = 0; i < wordArr.length; i++)
      a.push(wordArr[i]);
    a.print();
  }
}
