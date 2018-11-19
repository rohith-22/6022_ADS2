import java.util.HashSet;
import java.util.Set;
/**
 * Class for boggle solver.
 */
public class BoggleSolver {
  /**
   * trieSET object.
   */
  private TrieSET trie;
  /**
   * Constructs the object.
   *
   * @param      dictionary  The dictionary
   */
  public BoggleSolver(final String[] dictionary) {
    trie = new TrieSET();

    for (String s : dictionary) {
      trie.add(s);
    }

  }
  /**
   * Gets all valid words.
   *
   * @param      board  The board
   *
   * @return     All valid words.
   */
  public Iterable<String> getAllValidWords(final BoggleBoard board) {
    Set<String> validWords = new HashSet<String>();
    if (board == null) {
      throw new NullPointerException("board is null");
    }
    for (int i = 0; i < board.rows(); i++) {
      for (int j = 0; j < board.cols(); j++) {
        boolean[][] markedArray = new boolean[board.rows()][board.cols()];
        collect(board, i, j, markedArray, "", validWords);
      }
    }

    return validWords;
  }
  /**
   * This is a recursive function which collects all the words.
   *
   * @param      board        The board
   * @param      row          The row
   * @param      col          The col
   * @param      markedArray  The marked array
   * @param      prefix       The prefix
   * @param      set          The set
   */
  private void collect(final BoggleBoard board, final int row, final int col,
                       final boolean[][] markedArray, final String prefix,
                       final Set<String> set) {
    if (markedArray[row][col]) {
      return;
    }

    char letter = board.getLetter(row, col);
    String word = prefix;

    if (letter == 'Q') {
      word += "QU";
    } else {
      word += letter;
    }

    if (!trie.hasPrefix(word)) {
      return;
    }

    if (word.length() > 2 && trie.contains(word)) {
      set.add(word);
    }

    markedArray[row][col] = true;

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0) {
          continue;
        }

        if ((row + i >= 0) && (row + i < board.rows())
            && (col + j >= 0) && (col + j < board.cols())) {
          collect(board, row + i, col + j, markedArray, word, set);
        }
      }
    }

    markedArray[row][col] = false;
  }
// Returns the score of the given word
// if it is in the dictionary, zero otherwise.
// (You can assume the word contains only the uppercase letters A through Z.)

  /**
   * this fuction is used to find the scores.
   *
   * @param      word  The word
   *
   * @return     The int score.
   */
  public int scoreOf(final String word) {
    final int two = 2, three = 3, four = 4, five = 5, six = 6, seven = 7,
              eleven = 11;
    if (trie.contains(word)) {
      switch (word.length()) {
      case 0:
      case 1:
      case two:
        return 0;
      case three:
      case four:
        return 1;
      case five:
        return two;
      case six:
        return three;
      case seven:
        return five;
      default:
        return eleven;
      }
    } else {
      return 0;
    }
  }

}
