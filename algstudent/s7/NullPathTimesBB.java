package labs.examples.branchandbound.pyramid;

public class NullPathTimesBB {
	public static void main(String[] args) {
        int[] sizes = {20, 25, 30, 35, 40};
        int trials = 100;
        int minWeight = 10, maxWeight = 99, tolerance = 99;

        for (int n : sizes) {
            long total = 0;
            for (int i = 0; i < trials; i++) {
                int[][] weights = NullPathBB.generateRandomMatrix(n, minWeight, maxWeight);
                NullPathNode root = new NullPathNode(weights, n, tolerance, 0, n - 1);
                NullPathBB solver = new NullPathBB();
                long start = System.currentTimeMillis();
                solver.branchAndBound(root);
                long end = System.currentTimeMillis();
                total += (end - start);
            }
            double average = total / (double) trials;
            System.out.printf("n = %d, Average Time = %.2f ms%n", n, average);
        }
    }
}
