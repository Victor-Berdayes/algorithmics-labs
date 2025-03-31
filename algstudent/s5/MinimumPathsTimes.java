package labs.en._25.algstudent.s5;

public class MinimumPathsTimes {
	public static void main(String[] args) {
		int[] sizes = {200, 400, 800, 1600, 3200};
		System.out.println("n\tTime (ms)");
		for (int n : sizes) {
			int[][] weights = MinimumPaths.generateRandomWeights(n);
			int[][] costs = new int[n][n];
			int[][] p = new int[n][n];

			long start = System.currentTimeMillis();
			MinimumPaths.floyd(weights, costs, p);
			long end = System.currentTimeMillis();

			System.out.println(n + "\t" + (end - start));
		}
	}
}
