import java.util.HashSet;
import java.util.Set;
public class BoggleSolver {
  private TrieSET trie;
  public BoggleSolver(String[] dictionary) {
    trie = new TrieSET();

    for (String s : dictionary) {
      trie.add(s);
    }

  }

// Returns the set of all valid words in the given Boggle board, as an Iterable.
  public Iterable<String> getAllValidWords(BoggleBoard board) {
    Set<String> validWords = new HashSet<String>();
    if (board == null) {
      throw new NullPointerException("board is null");
    }
    for (int i = 0; i < board.rows(); i++) {
      for (int j = 0; j < board.cols(); j++) {
        boolean[][] markedArray = new boolean[board.rows()][board.cols()];
        dfs(board, i, j, markedArray, "", validWords);
      }
    }

    return validWords;
  }
  private void dfs(BoggleBoard board, int row, int col, boolean[][] markedArray, String prefix, Set<String> set) {
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

        if ((row + i >= 0) && (row + i < board.rows()) && (col + j >= 0) && (col + j < board.cols())) {
          dfs(board, row + i, col + j, markedArray, word, set);
        }
      }
    }

    markedArray[row][col] = false;
  }
// Returns the score of the given word if it is in the dictionary, zero otherwise.
// (You can assume the word contains only the uppercase letters A through Z.)
  public int scoreOf(String word) {
    if (trie.contains(word)) {
      switch (word.length()) {
      case 0:
      case 1:
      case 2:
        return 0;
      case 3:
      case 4:
        return 1;
      case 5:
        return 2;
      case 6:
        return 3;
      case 7:
        return 5;
      default:
        return 11;
      }
    } else {
      return 0;
    }
  }

}