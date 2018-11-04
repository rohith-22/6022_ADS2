import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     *Time Complexity : O(V).
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String synset = sc.nextLine();
        String hypernyms = sc.nextLine();
        try {
            WordNet wN = new WordNet(synset, hypernyms);
            String inputType = sc.nextLine();
            if (wN.gethasCycle()) {
                System.out.println("Cycle detected");
                return;
            }

            if (inputType.equals("Graph")) {
                wN.checkMultipleRoots();
                if (wN.gethasMultipleRoots()) {
                    return;
                } else {

                    System.out.println(wN.getDigraph());
                }
            }
            if (inputType.equals("Queries")) {
                while (sc.hasNextLine()) {
                    String[] tokens = sc.nextLine().split(" ");
                    try {
                        wN.sap(tokens[0], tokens[1]);
                        System.out.println("distance = "
                         + wN.distance(tokens[0], tokens[1])
                          + ", ancestor = " + wN.sap(tokens[0], tokens[1]));

                    } catch (Exception e) {
                        System.out.println("IllegalArgumentException");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


