import java.util.Scanner;
import java.util.HashMap;
/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Don't modify this method.
  */
  private Solution() {
    // unused.
  }
  /**
   * main function to handle testcases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    String cases = scan.nextLine();

    switch (cases) {
    case "loadDictionary":
      // input000.txt and output000.txt
      BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
      while (scan.hasNextLine()) {
        String key = scan.nextLine();
        System.out.println(hash.get(key));
      }
      break;

    case "getAllPrefixes":
      // input001.txt and output001.txt
      T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
      while (scan.hasNextLine()) {
        String prefix = scan.nextLine();
        for (String each : t9.getAllWords(prefix)) {
          System.out.println(each);
        }
      }
      break;

    case "potentialWords":
      // input002.txt and output002.txt
      t9 = new T9(loadDictionary("/Files/t9.csv"));
      int count = 0;
      while (scan.hasNextLine()) {
        String t9Signature = scan.nextLine();
        for (String each : t9.potentialWords(t9Signature)) {
          count++;
          System.out.println(each);
        }
      }
      if (count == 0) {
        System.out.println("No valid words found.");
      }
      break;

    case "topK":
      // input003.txt and output003.txt
      t9 = new T9(loadDictionary("/Files/t9.csv"));
      Bag<String> bag = new Bag<String>();
      int k = Integer.parseInt(scan.nextLine());
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        bag.add(line);
      }
      for (String each : t9.getSuggestions(bag, k)) {
        System.out.println(each);
      }

      break;

    case "t9Signature":
      // input004.txt and output004.txt
      t9 = new T9(loadDictionary("/Files/t9.csv"));
      bag = new Bag<String>();
      k = Integer.parseInt(scan.nextLine());
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        for (String each : t9.t9(line, k)) {
          System.out.println(each);
        }
      }
      break;

    default:
      break;

    }
  }
  /**
   * Don't modify this method.
   */

  /**
   * reads the file.
   *
   * @param      file  The file
   *
   * @return     string array of files
   */
  public static String[] toReadFile(final String file) {
    In in = new In(file);
    return in.readAllStrings();
  }
  /**
   * Loads a dictionary.
   *
   * @param      file  The file
   *
   * @return     dictionary.
   */
  public static BinarySearchST<String, Integer> loadDictionary(final
      String file) {
    BinarySearchST<String, Integer>  objectST
      = new BinarySearchST<String, Integer>();
    String[] fileArray = toReadFile(file);
    for (String word : fileArray) {
      word = word.toLowerCase();
      if (!objectST.contains(word)) {
        objectST.put(word, 1);
      } else {
        objectST.put(word, objectST.get(word) + 1);
      }
    }
    return objectST;
  }

}
/**
 * Class for t 9.
 */
class T9 {
  /**
   * private TST object.
   */
  private TST<Integer> wordsTst;
  /**
   * Constructs the object.
   *
   * @param      st    symbol table.
   */
  public T9(final BinarySearchST<String, Integer> st) {
    // your code goes here

    wordsTst = new TST();

    for (String each : st.keys()) {
      wordsTst.put(each, st.get(each));
    }
  }

  /**
   * Gets all words.
   *
   * @param      prefix  The prefix
   *
   * @return     All words.
   */
  public Iterable<String> getAllWords(final String prefix) {
    // your code goes here
    return wordsTst.keysWithPrefix(prefix);
  }
  /**
   * checks for potential words.
   *
   * @param      t9Signature  The t 9 signature
   *
   * @return     potential words iterable
   */
  public Iterable<String> potentialWords(final String t9Signature) {
    // your code goes here

    return null;
  }

  // return all possibilities(words), find top k with highest frequency.

  /**
   * Gets the suggestions.
   *
   * @param      words  The words
   * @param      k      The int
   *
   * @return     The suggestions.
   */
  public Iterable<String> getSuggestions(final Iterable<String> words,
                                         final int k) {
    // your code goes here
    HashMap objectMap = new HashMap<String, Integer>();
    for (String each : words) {
      for (String eachWord : getAllWords(each)) {
      }
    }

    return null;
  }

  // final output
  // Don't modify this method.

  /**
   * t9 dictionary.
   *
   * @param      t9Signature  The t 9 signature
   * @param      k            The int.
   *
   * @return     returns iterrable string.
   */
  public Iterable<String> t9(final String t9Signature, final int k) {
    return getSuggestions(potentialWords(t9Signature), k);
  }
}
