
/**
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

/**
 * Class for depth first paths.
 */
class DepthFirstPaths {
  /**
   * { var_description }.
   */
  private boolean[] marked;
  /**
   * { item_description }.
   */// marked[v] = is there an s-v path?
  private int[] edgeTo;
  /**
   * { item_description }.
   *edgeTo[v] = last edge on s-v path
   */
  /**
   * { var_description }.
   */
  private final int s;         // source vertex

  /**
   * Computes a path between {@code s} and .
   * @param G the graph
   * @param s the source vertex
   * @throws IllegalArgumentException unless {@code 0 <= s < V}
   */
  public DepthFirstPaths(Graph G, int s) {
    this.s = s;
    edgeTo = new int[G.V()];
    marked = new boolean[G.V()];
    validateVertex(s);
    dfs(G, s);
  }

  // depth first search from v

  /**
   * { function_description }.
   *
   * @param      G     { parameter_description }
   * @param      v     { parameter_description }
   */
  private void dfs(Graph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
    }
  }

  /**
   * Is there a path between the source vertex.
   * @param v the vertex
   * @return {@code true} if there is a path, {@code false} otherwise
   * @throws IllegalArgumentException unless {@code 0 <= v < V}
   */
  public boolean hasPathTo(int v) {
    validateVertex(v);
    return marked[v];
  }
  /**
   * { function_description }.
   *
   * @param      v     { parameter_description }
   */
  private void validateVertex(int v) {
    int V = marked.length;
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v
                                         + " is not between 0 and " +
                                         (V - 1));
  }
}
