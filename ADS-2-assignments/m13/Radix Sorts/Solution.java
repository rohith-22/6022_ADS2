import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for lsd.
 */
class LsdSort {
  /**
   * Constructs the object.
   */
  LsdSort() {

  }
  /**
    * Rearranges the array of W-character strings in ascending order.
    *
    * @param a the array to be sorted
    * @param w the number of characters per string
    * @return           returns The sorted Array.
    */
  public String[] sort(final String[] a, final int w) {
    int n = a.length;
    final int extendedAscii = 256;
    String[] aux = new String[n];

    for (int d = w - 1; d >= 0; d--) {

      // compute frequency counts
      int[] count = new int[extendedAscii + 1];
      for (int i = 0; i < n; i++) {
        count[a[i].charAt(d) + 1]++;
      }

      // compute cumulates
      for (int r = 0; r < extendedAscii; r++) {
        count[r + 1] += count[r];
      }

      // move data
      for (int i = 0; i < n; i++) {
        aux[count[a[i].charAt(d)]++] = a[i];
      }

      // copy back
      for (int i = 0; i < n; i++) {
        a[i] = aux[i];
      }
    }
    return a;
  }
}
/**
 * class for Solution which has main function.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main function handle test cases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    int noOfInputs = Integer.parseInt(sc.nextLine());
    String[] arrayOfInputs = new String[noOfInputs];

    for (int i = 0; i < noOfInputs; i++) {
      arrayOfInputs[i] = sc.nextLine();
    }
    arrayOfInputs = new LsdSort().sort(arrayOfInputs,
                                       arrayOfInputs[0].length());
    System.out.println(Arrays.toString(arrayOfInputs));
  }
}
