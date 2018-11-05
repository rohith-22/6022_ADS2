import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for page rank.
 */
class PageRank {
  /**
   * variable digraph object.
   */
  private Digraph graph;
  /**
   * variable int vertices.
   */
  private int vertices;
  /**
   * page rank array.
   */
  private double[] prArray;
  /**
   * pagerank array2.
   */
  private double[] prArrayTwo;
  /**
   * Constructs the object.
   *
   * @param      dG    The d g
   * @param      v     vertices.
   */
  PageRank(final Digraph dG, final int v) {
    this.graph = dG;
    this.vertices = v;

    calculation();
  }
  /**
   * claculation of pr is done here.
   * time complexity is O(2V + (1000 * V^2 * E ) + V^2).
   */
  public void calculation() {
    final int thousand = 1000;
    double temp = 1 / vertices;
    prArray = new double[vertices];
    prArrayTwo = new double[vertices];
    for (int i = 0; i < vertices; i++) {
      prArray[i] = (double) 1 / vertices;
    }
    // for (int i = 0; i < vertices; i++) {
    //   if (graph.outdegree(i) == 0) {
    //     for (int j = 0; j < vertices; j++) {
    //       if (j != i) {
    //         graph.addEdge(i, j);
    //       }
    //     }
    //   }
    // }
    // System.arraycopy(prArray, 0, prArrayTwo, 0, vertices);
    // for (int j = 0; j < thousand; j++) {
    //   for (int i = 0; i < vertices; i++) {
    //     prArray[i] = 0.0;
    //     for (Integer w :  graph.reverse().adj(i)) {
    //       prArray[i] += prArrayTwo[w] / graph.outdegree(w);

    //     }
    //   }
    //   System.arraycopy(prArray, 0, prArrayTwo, 0, vertices);

    // }
  }
  /**
   * Gets the pr.
   * time complexity is o(1).
   *
   * @param      v     vertices.
   *
   * @return     The pr.
   */
  public double getPR(final int v) {
    return prArray[v];
  }

}
/**
 * Class for web search.
 */
class WebSearch {

}

/**
 * solution class.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main function.
   * time complexity is O((V*E) + V)
   * V is vertices, E is edges.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    // read the first line of the input to get the number of vertices
    Scanner sc = new Scanner(System.in);
    int noOfVertices = Integer.parseInt(sc.nextLine());
    // iterate count of vertices times
    // to read the adjacency list from std input
    // and build the graph
    Digraph graph = new Digraph(noOfVertices);
    for (int i = 0; i < noOfVertices; i++) {
      String[] tokens = sc.nextLine().split(" ");
      for (int j = 1; j < tokens.length; j++) {
        graph.addEdge(Integer.parseInt(tokens[0]),
                      Integer.parseInt(tokens[j]));
      }
    }
    System.out.println(graph);
    // Create page rank object and pass the graph object to the constructor
    PageRank objPR = new PageRank(graph, noOfVertices);
    for (int i = 0; i < noOfVertices; i++) {
      System.out.println(i + " - " + objPR.getPR(i));
    }
    // print the page rank object

    // This part is only for the final test case

    // File path to the web content
    String file = "WebContent.txt";

    // instantiate web search object
    // and pass the page rank object and the file path to the constructor

    // read the search queries from std in
    // remove the q= prefix and extract the search word
    // pass the word to iAmFeelingLucky method of web search
    // print the return value of iAmFeelingLucky

  }
}
