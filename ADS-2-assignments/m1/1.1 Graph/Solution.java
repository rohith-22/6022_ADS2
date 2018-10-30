import java.util.Scanner;

class ListGraph {

	private int vertices;

	private int edges;

	private Bag<Integer>[] adjacent;

	private String[] tokens;

	ListGraph() {

	}

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

	public Iterable<Integer> adj(final int vertex) {
		return adjacent[vertex];
	}

	public boolean hasEdge(final int vertexOne,
	                       final int vertexTwo) {
		for (int each : adj(vertexOne))  {
			if (each == vertexTwo) {
				return true;
			}
		}
		return false;
	}

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

class MatrixGraph {

	private String[] tokens;

	private int[][] graphMatrix;

	private int vertices;

	private int edges;

	MatrixGraph() {

	}

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

	public void addEdge(final int vertexOne, final int vertexTwo) {
		if (vertexOne != vertexTwo) {
			if (!hasEdge(vertexOne, vertexTwo)) {
				graphMatrix[vertexOne][vertexTwo] = 1;
				graphMatrix[vertexTwo][vertexOne] = 1;
				edges++;
			}
		}

	}

	public boolean hasEdge(final int vertexOne, final int vertexTwo) {
		return graphMatrix[vertexOne][vertexTwo] == 1;
	}

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

final class Solution {

	private Solution() {

	}

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