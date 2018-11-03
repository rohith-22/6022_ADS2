import java.util.Scanner;
class PageRank {
  Digraph graph;
  int vertices;
  double[] prArray;
  Iterable<Integer> adjacent;
  PageRank(final Digraph dG, int v) {
    this.graph = dG;
    this.vertices = v;

    calculation();
  }
  public void calculation() {
    double temp = 1 / vertices;
    prArray = new double[vertices];
    for (int i = 0; i < vertices; i++) {
      prArray[i] = (double) 1 / vertices;

    }
  }
  public double getPR(int v) {
    return prArray[v];
  }

}

class WebSearch {

}


public final class Solution {
  private Solution() {

  }
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
        graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[j]));
      }
    }
    System.out.println(graph);
    // Create page rank object and pass the graph object to the constructor
    PageRank objPR = new PageRank(graph, noOfVertices);
    for (int i = 0; i < noOfVertices; i++) {
      System.out.println(objPR.getPR(i));
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
