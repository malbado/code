//Binary Tree
//This script print out the nodes of distance j from node i
public class test3
{

  int distance(int[] a, int i, int j)
    {
      int count = 0;
      i ++;
      j ++;
      while (i != j)
       {
          while (i/2 > j/2)
            {
               i = i/2;
               count ++;
            }
          while(j/2 > i/2)
            {
              j = j/2;
              count ++;
            }
         if (i/2 == j/2)
          {
            count = count + 2;
            i = j = i/2;
          }
       }
      return count;
    }

  void distanceNodesDown(int i, int k, int size)
     {
        if (k == 0)
          System.out.println(Integer.toString(i));
        else if (k > 0)
         {
           if (2*i <= size)
           distanceNodesDown (i * 2, k-1, size);
           if (2*i + 1 <= size)
           distanceNodesDown (i * 2 + 1, k-1, size);
         }

     }

  void distanceNodesUp(int i, int k, int size)
     {
       if (k == 0 || i == 1)
           System.out.println(Integer.toString(i));
       else
         {         
            if (i > (i/2) * 2)
              distanceNodesDown (i-1, k-2, size);
            else
              distanceNodesDown (i+1, k-2, size);

           if (i/2 >= 1)
             distanceNodesUp(i/2, k-1, size);
         }
     }
  public static void main (String[] args)
  {
    int i = 0;
    int j = 0;
    //size of the Binary tree
    int k = 0;
    test3 t = new test3();
    int[] a = new int[]{1,2,3,4,5,6,7,8};
    try
      {
        i = Integer.parseInt(args[0]);
        j = Integer.parseInt(args[1]);
        k = Integer.parseInt(args[2]);
      }
    catch(NumberFormatException nfe)
      {
        System.out.println("Entry should be integer.");
        System.exit(1);
      }
     //int dist = t.distance(a, i, j);
     //System.out.println(Integer.toString(dist));
     t.distanceNodesDown(i, j, k);
     t.distanceNodesUp(i, j, k);
  }
}
