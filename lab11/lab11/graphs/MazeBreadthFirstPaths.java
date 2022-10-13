package lab11.graphs;

import edu.princeton.cs.algs4.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int source;
    private int target;
    private boolean targetFound = false;
    private Queue<Integer> fringe = new Queue<>();

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        source = maze.xyTo1D(sourceX, sourceY);
        target = maze.xyTo1D(targetX, targetY);
        distTo[source] = 0;
        edgeTo[source] = source;
        fringe.enqueue(source);
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        while (!fringe.isEmpty()) {
            int node = fringe.dequeue();
            marked[node] = true;
            announce();
            if (node == target) {
                targetFound = true;
                return;
            }
            for (int neighbor: maze.adj(node)) {
                if (!marked[neighbor]) {
                    fringe.enqueue(neighbor);
                    distTo[neighbor] = distTo[node] + 1;
                    edgeTo[neighbor] = node;
                    announce();
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs();
    }
}

