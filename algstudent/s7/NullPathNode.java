package labs.examples.branchandbound.pyramid;

import labs.examples.branchandbound.pyramid.utils.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class NullPathNode extends Node {
    private int[][] weights;
    private boolean[] visited;
    private int[] path;
    private int pathLen;
    private int cost;
    private int n;
    private int tolerance;
    private int start;
    private int target;

    public NullPathNode(int[][] weights, int n, int tolerance, int start, int target) {
        this.weights = weights;
        this.n = n;
        this.tolerance = tolerance;
        this.start = start;
        this.target = target;
        this.visited = new boolean[n];
        this.path = new int[n];
        this.path[0] = start;
        this.pathLen = 1;
        this.visited[start] = true;
        this.cost = 0;
        calculateHeuristicValue();
    }

    private NullPathNode(NullPathNode parent, int nextNode) {
        this.weights = parent.weights;
        this.n = parent.n;
        this.tolerance = parent.tolerance;
        this.start = parent.start;
        this.target = parent.target;

        this.visited = Arrays.copyOf(parent.visited, n);
        this.path = Arrays.copyOf(parent.path, n);
        this.pathLen = parent.pathLen + 1;
        this.cost = parent.cost + weights[parent.path[parent.pathLen - 1]][nextNode];

        this.visited[nextNode] = true;
        this.path[pathLen - 1] = nextNode;
        this.parentID = parent.getID();
        calculateHeuristicValue();
    }

    @Override
    public void calculateHeuristicValue() {
        this.heuristicValue = Math.abs(cost);
    }

    @Override
    public ArrayList<Node> expand() {
        ArrayList<Node> children = new ArrayList<>();
        int last = path[pathLen - 1];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                NullPathNode child = new NullPathNode(this, i);
                if (Math.abs(child.cost) <= tolerance) {
                    children.add(child);
                }
            }
        }
        return children;
    }

    @Override
    public boolean isSolution() {
        return pathLen == n && path[pathLen - 1] == target && Math.abs(cost) <= tolerance;
    }

    @Override
    public int initialValuePruneLimit() {
        return tolerance + 1;
    }

    @Override
    public String toString() {
        return "Path: " + Arrays.toString(Arrays.copyOf(path, pathLen)) + " | Cost: " + cost;
    }
}
