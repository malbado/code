
class Node<Item>
 {
   Item item;
   Node next;
  }

public class LinkedList
{


  void createScenarioOK(Node node, int n)
  {
    Node first = node;
    Node last = node;
    for (int i = 1; i < n; ++i)
      {
        Node oldLast = last;
        last = new Node<String>();
        last.next = null;
        last.item = Integer.toString(i);
        oldLast.next = last;
      }
  }

  boolean checkLoop(Node node)
  {
    Node pointer1 = node;
    Node pointer2 = pointer1.next;
    Node pointer3 = pointer2.next;
    
    while(pointer1 != null && pointer2 != null &&  pointer3 != null)
      {

        if (pointer1 == pointer2 || pointer1 == pointer3)
          return true;
        if (pointer3.next == null) break;
        pointer2 = pointer3.next;
        if (pointer2.next == null) break;
        pointer3 = pointer2.next;
        pointer1 = pointer1.next;
      }

    return false;
  }
  
  int size(Node node)
  {
    Node pointer1 = node;
    Node pointer2 = pointer1.next;
    Node pointer3 = pointer2.next;
    Node loopPoint = new Node<String>();
    int count = 0;   
    int count1 = 0;
    while(pointer1 != null && pointer2 != null &&  pointer3 != null)
      {

        if (pointer1 == pointer2)
          break;
        if (pointer1 == pointer3)
          break;

        if (pointer3.next == null) break;
        count++;
        pointer2 = pointer3.next;         
        if (pointer2.next == null) break;
        count++;
        pointer3 = pointer2.next;
        if (pointer1.next != null)
        pointer1 = pointer1.next;
        count1++;
      }

    return count + 3;
  }

  int size2(Node node)
  {
    Node pointer1 = node;
    Node pointer2 = pointer1.next;
    Node pointer3 = pointer2.next;
    Node loopPoint = new Node<String>();
    int count = 0;   
    int count1 = 0;
    while(pointer1 != null && pointer2 != null &&  pointer3 != null)
      {

        if (pointer1 == pointer2)
          break;
        if (pointer1 == pointer3)
          break;

        if (pointer3.next == null) break;
        count++;
        pointer2 = pointer3.next;         
        if (pointer2.next == null) break;
        count++;
        pointer3 = pointer2.next;
        if (pointer1.next != null)
        pointer1 = pointer1.next;
        count1++;
      }

    return count1 + 3;
  }


  Node loopPoint(Node node)
  {
    Node pointer1 = node;
    Node pointer2 = pointer1.next;
    Node pointer3 = pointer2.next;
    
    while(pointer1 != null && pointer2 != null &&  pointer3 != null)
      {

        if (pointer1 == pointer2 || pointer1 == pointer3)
          return pointer1;
        if (pointer3.next == null) break;
        pointer2 = pointer3.next;
        if (pointer2.next == null) break;
        pointer3 = pointer2.next;
        pointer1 = pointer1.next;
      }
    return null;
  }

  void createScenarioLoop(Node node, int n)
  {
    Node first = node;
    Node last = node;
    Node nodeLoop = new Node<String>();
    for (int i = 1; i < n; ++i)
      {
        Node oldLast = last;
        last = new Node<String>();
        last.next = null;
        last.item = Integer.toString(i);
        oldLast.next = last;
        if (i == n - 1)
         {
           last.next = nodeLoop;
         }

        if (i == n/5)
         {
           nodeLoop = last; 
           System.out.println("Create loop: " + nodeLoop.item);
         }
      }
  }
  Node meetingPoint(Node first, Node loop, int min)
  {
   int max = min*2;
   int j = min;
   Node p1 = first;
   Node p2 = loop;
   Node p3 = loop;
  while (j < max){
   p1 = first;
   p2 = loop;
   p3 = p2.next;
   for (int i =0 ;  i < j; i++)
     p1 = p1.next;
   while (p1 != p2 && p1 !=p3)
    {
      p2 = p3.next;
      p3 = p2.next; 
      if (p2 == loop){
        if (max - j == 1)
          j = max;
        else
          {
            min = j;
            j = (j + max)/2;
          }
        break;
      }
    }
   if(p1 == p2 || p1 == p3){
    max = j;
    if (j == min)
       j = min = min/2;
    else
      {
        j = (min + j)/2;
      }
    }
    System.out.println("==================" + Integer.toString(j));
    }
    return p1.next;
  }
  public static void main(String[] args)
  {
    LinkedList a = new LinkedList();
    Node<String> node1 = new Node<String>();
    node1.next = null;
    node1.item = Integer.toString(0);
    Node<String> node2 = new Node<String>();
    node2.next = null;
    node2.item = Integer.toString(0);
    a.createScenarioOK(node1, 1345431);
    a.createScenarioLoop(node2, 7478471);
    boolean result1 = a.checkLoop(node1);
    boolean result2 = a.checkLoop(node2);
    int size1 = a.size(node1);
    int size2 = a.size2(node2);    
    System.out.println("Result1: " + Boolean.toString(result1) + " Size1:" + Integer.toString(size1));
    //System.out.println("Result2: " + Boolean.toString(result2) + " Size2:" + Integer.toString(size2));
    Node loop = a.loopPoint(node2);
    Node point = a.meetingPoint(node2, loop, size2/2);
    //Node point2 = a.meetingPoint(node2, point);
    //Node point3 = a.meetingPoint(node2, point2);
    //System.out.println("LoopPoint: " + loop.item + "  Point: " + point.item);
  }

}
