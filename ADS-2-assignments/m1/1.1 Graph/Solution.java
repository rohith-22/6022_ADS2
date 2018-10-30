import java.util.Scanner;
/**
 * Class for list graph.
 */
class ListGraph {
  /**
   * variable  vertices.
   */
  private int vertices;
  /**
   * variable  edges.
   */
  private int edges;
  /**
   * object variable for Bag.
   */
  private Bag<Integer>[] adjacent;
  /**
   * variable String array.
   */
  private String[] tokens;
  /**
   * Constructs the object.
   */
  ListGraph() {

  }
  /**
   * Constructs the object.
   * overloaded constructor.
   *
   * @param      sc    The scan
   */
  ListGraph(final Scanner sc) {
    this.vertices = Integer.parseInt(sc.nextLine());
    adjacent = (Bag<Integer>[]) new Bag[vertices];
    for (int i = 0; i < vertices; i++) {
      adjacent[i] = new Bag<Integer>();
    }
    int edge = Integer.parseInt(sc.nextLine());
    tokens = sc.nextLine().split(",");
    for (int i = 0; i < edge; i++) {
      String[] inputs = sc.nextLine().split(" ");
      addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }
  }
  /**
   * Adds two vertices creating an edge.
   * Time complexity of this method is O(N)
   *
   * @param      vertexOne  The vertex one
   * @param      vertexTwo  The vertex two
   */
  public void addEdge(final int vertexOne, final int vertexTwo) {
    if (vertexOne == vertexTwo) {
      return;
    }
    if (!hasEdge(vertexOne, vertexTwo)) {
      edges++;
    }
    adjacent[vertexOne].add(vertexTwo);
    adjacent[vertexTwo].add(vertexOne);
  }
  /**
   * This method is used to iterate through graph.
   *
   * @param      vertex  The vertex
   *
   * @return     The iterable
   */
  public Iterable<Integer> adj(final int vertex) {
    return adjacent[vertex];
  }
  /**
   * Determines if it has edge.
   *
   * Time complexity of this method is O(N)
   *
   * @param      vertexOne  The vertex one
   * @param      vertexTwo  The vertex two
   *
   * @return     True if has edge, False otherwise.
   */
  public boolean hasEdge(final int vertexOne,
                         final int vertexTwo) {
    for (int each : adj(vertexOne))  {
      if (each == vertexTwo) {
        return true;
      }
    }
    return false;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append(vertices + " vertices, " + edges + " edges" + "\n");
    if (edges > 0) {
      for (int i = 0; i < vertices; i++) {
        str.append(tokens[i] + ": ");
        for (int j : adjacent[i]) {
          str.append(tokens[j] + " ");
        }
        str.append("\n");
      }
      return str.toString();
    } else {
      str.append("No edges");
      return str.toString();
    }
  }
}
/**
 * Class for matrix graph.
 */
class MatrixGraph {
  /**
   *variable  Strign array.
   */
  private String[] tokens;
  /**
   * variable graphMatrix.
   */
  private int[][] graphMatrix;
  /**
   * variable vertices.
   */
  private int vertices;
  /**
   * variable edges.
   */
  private int edges;
  /**
   * Constructs the object.
   */
  MatrixGraph() {

  }
  /**
   * Constructs the object.
   *
   *
   * @param      sc    The screen
   */
  MatrixGraph(final Scanner sc) {
    this.vertices = Integer.parseInt(sc.nextLine());
    graphMatrix = new int[vertices][vertices];
    int edge = Integer.parseInt(sc.nextLine());
    tokens = sc.nextLine().split(",");
    for (int i = 0; i < edge; i++) {
      String[] inputs = sc.nextLine().split(" ");
      addEdge(Integer.parseInt(
                inputs[0]), Integer.parseInt(inputs[1]));
    }

  }
  /**
   * Adds an edge.
   * Time complexity of this method is O(N)
   *
   * @param      vertexOne  The vertex one
   * @param      vertexTwo  The vertex two
   */
  public void addEdge(final int vertexOne, final int vertexTwo) {
    if (vertexOne != vertexTwo) {
      if (!hasEdge(vertexOne, vertexTwo)) {
        graphMatrix[vertexOne][vertexTwo] = 1;
        graphMatrix[vertexTwo][vertexOne] = 1;
        edges++;
      }
    }

  }
  /**
   * Determines if it has edge.
   * Time complexity of this method is O(N
   *
   * @param      vertexOne  The vertex one
   * @param      vertexTwo  The vertex two
   *
   * @return     True if has edge, False otherwise.
   */
  public boolean hasEdge(final int vertexOne, final int vertexTwo) {
    return graphMatrix[vertexOne][vertexTwo] == 1;
  }
  /**
   * This method is nothing but a tostring.
   * prints string representation.
   * Time complexity of this method is O(N)
   */
  public void print() {
    String str = "";
    str += vertices + " vertices, " + edges + " edges" + "\n";
    if (edges > 0) {
      for (int i = 0; i < graphMatrix.length; i++) {
        for (
          int j = 0; j < graphMatrix[0].length; j++) {
          str += graphMatrix[i][j] + " ";
        }
        str += "\n";
      }
      System.out.println(str);
    } else {
      System.out.println(str + "No edges");
    }
  }
}
/**
 * class for solution.
 */
final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * this method handles testcases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    String type = sc.nextLine();
    switch (type) {
    case "List":
      ListGraph objectLG = new ListGraph(sc);
      System.out.println(objectLG.toString());
      break;
    case "Matrix":
      MatrixGraph objectMG = new MatrixGraph(sc);
      objectMG.print();
      break;
    default:
      break;
    }
  }
}