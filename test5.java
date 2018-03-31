//Sum
//some solution
public class test5
{

  int solutions(int[] A, int N)
  {
    int sum1 = 0;
    int sum2 = 0;
    int returnValue = -1;
    for (int i = 0; i < N; i++)
      sum1 = sum1 + A[i];

    //System.out.println(Integer.toString(sum1));
    
    for (int i = 1; i < N; i++)
     {
        sum2 = sum2 + A[i-1];
        if (sum1 - A[i] == 2 * sum2)
          System.out.println(Integer.toString(i));
          returnValue = i;
     }
    return returnValue;
  }

  int solution2(int[] A)
    {
       int small = -1;
       for (int i =0; i < A.length; i++)
         {
           if (A[i] > 0 && A[i] < small || A[i] > 0 && 0 > small)
             small = A[i];
         }
       for (int i =0; i < A.length; i++)
         {
           if (A[i] > 0 && A[i] < small || A[i] > 0 && 0 > small)
             small = A[i];
         } 

    }

public static void main(String[] args)
{
  int[] A = new int[]{-1, 3, -4, 5, 1, -6, 2, 1};

   test5 t = new test5();
   int i = t.solutions(A, A.length);
}

}
