import java.util.Scanner;
/**
 * Class for perculation.
 */
class Perculation {
	/**
	 * variable vertex.
	 */
	private int vertex;
	/**
	 * checks for perculation.
	 *
	 * @param      grid         The grid
	 * @param      objectGraph  The object graph
	 * @param      vertexOne    The vertex one
	 *
	 * @return     returns the boolean.
	 */
	public boolean perculation(final boolean[][] grid,
	                           final Graph objectGraph,
	                           final int vertexOne) {
		vertex = vertexOne;
		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				if (grid[i][j]) {
					int temp = simplify(i, j);
					if (i == 0) {

						objectGraph.addEdge(
						    temp, vertex * vertex);
					}
					if (i == vertex - 1) {
						objectGraph.addEdge(temp,
						                    vertex * vertex + 1);
					}
					if (i - 1 >= 0 && grid[i - 1][j]) {
						objectGraph.addEdge(temp,
						                    simplify(i - 1, j));
					}
					if (i + 1 < vertex && grid[i + 1][j]) {
						objectGraph.addEdge(
						    temp, simplify(i + 1, j));
					}
					if (j - 1 >= 0 && grid[i][j - 1]) {
						objectGraph.addEdge(temp,
						                    simplify(i, j - 1));
					}
					if (j + 1 < vertex && grid[i][j + 1]) {
						objectGraph.addEdge(
						    temp, simplify(i, j + 1));
					}

				}
			}
		}
		DepthFirstPaths objectDFP = new DepthFirstPaths(
		    objectGraph, vertex * vertex);
		return objectDFP.hasPathTo(vertex * vertex + 1);
	}
	/**
	 * this method gives the edge of graph.
	 *
	 * Time complexity is O(1).
	 * @param      row     The row
	 * @param      column  The column
	 *
	 * @return      int
	 */
	public int simplify(final int row, final int column) {
		return row * vertex + column;
	}
}
/**
 * class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * main function to handle testcases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertex = Integer.parseInt(sc.nextLine());
		boolean[][] grid = new boolean[vertex][vertex];
		Perculation objectPerc = new Perculation();
		Graph objectGraph = new Graph(vertex * vertex + 2);
		try {
			while (sc.hasNext()) {
				int row = sc.nextInt(), col = sc.nextInt();
				grid[row - 1][col - 1] = true;

			}
		} catch (Exception e) {

		} finally {
			System.out.println(objectPerc.perculation(
			                       grid, objectGraph, vertex));
		}
	}
}