import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main function to handle the testcases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    // Self loops are not allowed...
    // Parallel Edges are allowed...
    // Take the Graph input here...
    Scanner scan = new Scanner(System.in);
    int vertices = Integer.parseInt(scan.nextLine());
    int edges = Integer.parseInt(scan.nextLine());
    EdgeWeightedGraph edgeGraph = new EdgeWeightedGraph(vertices);
    while (edges > 0) {
      String[] tokens = scan.nextLine().split(" ");
      int a = Integer.parseInt(tokens[0]);
      int b = Integer.parseInt(tokens[1]);
      double weight = Double.parseDouble(tokens[2]);
      Edge e = new Edge(a, b, weight);
      edgeGraph.addEdge(e);
      edges--;
    }
    String caseToGo = scan.nextLine();
    switch (caseToGo) {
    case "Graph":
      //Print the Graph Object.
      System.out.println(edgeGraph);
      break;

    case "DirectedPaths":
      // Handle the case of DirectedPaths, where two integers are given.
      // First is the source and second is the destination.
      // If the path exists print the distance between them.
      // Other wise print "No Path Found."
      String[] tokens = scan.nextLine().split(" ");
      int source = Integer.parseInt(tokens[0]);
      int destination = Integer.parseInt(tokens[1]);
      DijkstraUndirectedSP objectDSP =
        new DijkstraUndirectedSP(edgeGraph, source);
      if (objectDSP.hasPathTo(destination)) {
        System.out.println(objectDSP.distTo(destination));
      } else {
        System.out.println("No Path Found.");
      }
      break;
    case "ViaPaths":
      // Handle the case of ViaPaths, where three integers are given.
      // First is the source and second is the via is
      // the one where path should pass through.
      // third is the destination.
      // If the path exists print the distance between them.
      // Other wise print "No Path Found."
      String[] tokensTwo = scan.nextLine().split(" ");
      int sourceA = Integer.parseInt(tokensTwo[0]);
      int viaPath = Integer.parseInt(tokensTwo[1]);
      int destinationA = Integer.parseInt(tokensTwo[2]);
      DijkstraUndirectedSP objectDSPOne =
        new DijkstraUndirectedSP(edgeGraph, sourceA);
      DijkstraUndirectedSP objectDSPTwo =
        new DijkstraUndirectedSP(edgeGraph, viaPath);

      if (objectDSPOne.hasPathTo(destinationA)) {
        System.out.println(objectDSPOne.distTo(viaPath)
                           + objectDSPTwo.distTo(destinationA));
        System.out.println(objectDSPOne.pathTo(viaPath) + "" + objectDSPTwo.pathTo(destinationA));
      } else {
        System.out.println("No Path Found.");
      }
      break;
    default:
      break;
    }

  }
}
