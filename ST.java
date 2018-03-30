//1 milion entry
import java.util.HashMap;
import java.util.Map;

public class ST
{

  void exch (int[] a, int i, int j)
  {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

int partition(int[] a, int lo, int hi) {
  int i = lo;
  int j = hi + 1;
  while(true){
  
  while (a[++i] < a[lo])
    if (i == hi) break;

  while (a[--j] > a[lo])
    if (j == lo) break;

    if (i >= j) break;

    this.exch(a, i, j);
  }
  this.exch(a, j, lo);

  return j;
}

int minTopCount(int[] wordCount, int top) {
   int lo = 0;
   int hi = wordCount.length-1;
   while (hi > lo) {
    int j = this.partition(wordCount, lo, hi);
    if (j < top) lo = j + 1;
    else if (j > top) hi = j - 1;
    else break;
  }
   return wordCount[top];
}

public static void main(String[] args){

  int top =0;
  ST s = new ST();
  try
    {
      top = Integer.parseInt(args[0]);
    }
  catch (NumberFormatException nfe)
    {
      System.out.println("The number must be an Integer");
      System.exit(1);
    }
  String[] arr = {"aaa", "bbbb", "aaa", "ddddd", "dddd", "bbbb", "aaa", "ccc", "dddd", "ab", "sd", "th", "fdafdsgfsgfd", "sh", "aaa", "dddd", "sh", "ab", "fkfjf", "tr", "aaa", "bbbb", "ab", "sh", "sh", "ab", "ab", "aaa", "ccc", "ccc"};
  HashMap<String, Integer> map = new HashMap<String, Integer>();
  for (int i = 0; i < arr.length; i++)
   {
      int size = 0;
      if(map.get(arr[i]) != null)
        size = map.get(arr[i]);
     
      map.put(arr[i], size + 1);
   }
  int max = 0, i = 0;
  int[] value = new int[map.size()];
  for(Map.Entry<String, Integer> entry: map.entrySet())
    {
      System.out.println(entry.getKey() + " " + entry.getValue());
      value[i] = entry.getValue().intValue();
      i++;
    }
  System.out.println("\n============[Results]============");
  int minMax = s.minTopCount (value, value.length - top);
  for (Map.Entry<String, Integer> entry : map.entrySet())
    if (entry.getValue().intValue() >= minMax)
      System.out.println(entry.getKey() + "  " + entry.getValue());
}
}
