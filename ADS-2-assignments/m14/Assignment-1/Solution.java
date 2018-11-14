import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {
    //unused constructor.
  }
  /**
   * main function to handle testcases.
   *  Time complexity is K * N * (N+logN)
   *  N is no of words
   *  k is suffix arrray size.
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    String[] words = loadWords();
    //Your code goes here...
    TST<Integer> tst = new TST<Integer>();
    Scanner sc = new Scanner(System.in);
    String prefix = sc.nextLine();
    int j = 0;
    for (String word : words) {
      SuffixArray sa = new SuffixArray(word);
      for (int i = 0; i < word.length(); i++) {
        tst.put(sa.select(i), j++);
      }
    }
    for (String word : tst.keysWithPrefix(prefix)) {
      System.out.println(word);
    }
  }
  /**
   * Loads words from file.
   *
   * @return     returns the words array.
   */
  public static String[] loadWords() {
    In in = new In("/Files/dictionary-algs4.txt");
    String[] words = in.readAllStrings();
    return words;
  }
}

















