package lab11.graphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;

/**
 *  @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer {
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private MinPQ<Integer> fringe;

    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        fringe = new MinPQ<>(new MazeComp());
    }

    private class MazeComp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int dist1 = distTo[o1] + h(o1);
            int dist2 = distTo[o2] + h(o2);
            return dist1 - dist2;
        }
    }
    /** Estimate of the distance from v to the target. */
    private int h(int v) {
        int vX = maze.toX(v);
        int vY = maze.toY(v);
        int targetX = maze.toX(t);
        int targetY = maze.toY(t);
        return Math.abs(vX - targetX) + Math.abs(vY - targetY);
    }

    /** Finds vertex estimated to be closest to target. */
    private int findMinimumUnmarked() {
        return -1;
        /* You do not have to use this method. */
    }

    /** Performs an A star search from vertex s. */
    private void astar(int s) {
        fringe.insert(s);
        while (!fringe.isEmpty()) {
            int minNode = fringe.delMin();
            marked[minNode] = true;
            announce();
            if (minNode == t) {
                return;
            }
            for (int neighbor: maze.adj(minNode)) {
                if (!marked[neighbor]) {
                    distTo[neighbor] = distTo[minNode] + 1;
                    edgeTo[neighbor] = minNode;
                    fringe.insert(neighbor);
                    announce();
                }
            }
        }
    }

    @Override
    public void solve() {
        astar(s);
    }

}

