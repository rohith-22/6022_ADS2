import java.util.Scanner;

class Perculation {

	private int vertex;

	public boolean perculation(final boolean[][] grid,
	                           final Graph objectGraph,
	                           final int vertexOne) {
		vertex = vertexOne;
		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				if (grid[i][j]) {
					int tmp = simplify(i, j);
					if (i == 0) {

						objectGraph.addEdge(
						    tmp, vertex * vertex);
					}
					if (i == vertex - 1) {
						objectGraph.addEdge(tmp,
						                 vertex * vertex + 1);
					}
					if (i - 1 >= 0 && grid[i - 1][j]) {
						objectGraph.addEdge(tmp,
						                 simplify(i - 1, j));
					}
					if (i + 1 < vertex && grid[i + 1][j]) {
						objectGraph.addEdge(
						    tmp, simplify(i + 1, j));
					}
					if (j - 1 >= 0 && grid[i][j - 1]) {
						objectGraph.addEdge(tmp,
						                 simplify(i, j - 1));
					}
					if (j + 1 < vertex && grid[i][j + 1]) {
						objectGraph.addEdge(
						    tmp, simplify(i, j + 1));
					}

				}
			}
		}
		DepthFirstPaths objectDFP = new DepthFirstPaths(
		    objectGraph, vertex * vertex);
		return objectDFP.hasPathTo(vertex * vertex + 1);
	}

	public int simplify(final int row, final int column) {
		return row * vertex + column;
	}
}

final class Solution {

	private Solution() {

	}

	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertex = Integer.parseInt(sc.nextLine());
		boolean[][] grid = new boolean[vertex][vertex];
		Graph objectGraph = new Graph(vertex * vertex + 2);
		try {
			while (sc.hasNext()) {
				int row = sc.nextInt(), col = sc.nextInt();
				grid[row - 1][col - 1] = true;

			}
		} catch (Exception e) {

		} finally {
			Perculation objectPerc = new Perculation();
			System.out.println(objectPerc.perculation(
			                       grid, objectGraph, vertex));
		}
	}
}