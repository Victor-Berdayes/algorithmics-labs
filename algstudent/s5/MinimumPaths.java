package labs.en._25.algstudent.s5;

import java.util.Random;

public class MinimumPaths {
	static String[] v; //node vector
	static int[][] weights; //weight matrix
	static int[][] costs; //Floyd's paths cost matrix
	static int[][] p; //predecessor matrix (steps) in Floyd paths
	
	public static void main(String[] args) {
		
		int n = 5; //nodes of example graph
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;

		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];

		weights = generateRandomWeights(n);
		System.out.println("WEIGHT MATRIX IS:");
		printMatrix(weights);

		floyd(weights, costs, p);

		System.out.println("MINIMUM COST MATRIX IS:");
		printMatrix(costs);

		System.out.println("P MATRIX IS:");
		printMatrix(p);

		System.out.println();
		System.out.println("MINIMUM PATHS IN THE EXAMPLE GRAPH (for every pair of different nodes):");
		System.out.println();
	}

	public static int[][] generateRandomWeights(int size) {
		int[][] w = new int[size][size];
		Random rand = new Random();
		int INF = 10000000;
		int minWeight = 10;
		int maxWeight = 100;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					w[i][j] = 0;
				} else {
					w[i][j] = rand.nextInt(10) < 5 ? rand.nextInt(minWeight, maxWeight) : INF; 
				}
			}
		}
		return w;
	}

	public static void floyd(int[][] weights, int[][] costs, int[][] p) {
		int n = weights.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				costs[i][j] = weights[i][j];
				p[i][j] = (weights[i][j] != 10000000 && i != j) ? i : -1;
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (costs[i][k] + costs[k][j] < costs[i][j]) {
						costs[i][j] = costs[i][k] + costs[k][j];
						p[i][j] = p[k][j];
					}
				}
			}
		}
	}
	
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%10s", a[i][j]));
			System.out.println();
		}
		System.out.println();
	}
}
