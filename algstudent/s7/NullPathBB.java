package labs.examples.branchandbound.pyramid;

import labs.examples.branchandbound.pyramid.utils.BranchAndBound;
import labs.examples.branchandbound.pyramid.utils.Node;

public class NullPathBB extends BranchAndBound {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] weights = generateRandomMatrix(n, 10, 99);
        int tolerance = 99;

        NullPathNode root = new NullPathNode(weights, n, tolerance, 0, n - 1);
        NullPathBB solver = new NullPathBB();
        solver.branchAndBound(root);

        Node solution = solver.getBestNode();
        if (solution != null) {
            System.out.println("Solution: " + solution.toString());
        } else {
            System.out.println("No solution found.");
        }
    }

    public static int[][] generateRandomMatrix(int n, int minWeight, int maxWeight) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    boolean positive = Math.random() < 0.5;
                    int value = minWeight + (int)(Math.random() * (maxWeight - minWeight + 1));
                    matrix[i][j] = positive ? value : -value;
                }
            }
        }
        return matrix;
    }
}