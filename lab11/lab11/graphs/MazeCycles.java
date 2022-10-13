package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int cycleSource;
    private boolean isCycle = false;
    private boolean inCycle = false;

    public MazeCycles(Maze m) {
        super(m);
    }

    @Override
    public void solve() {
        for (int i = 0; i < maze.N() * maze.N(); i++) {
            if (!marked[i]) {
                cycleDetect(i, i);
                if (isCycle) {
                    return;
                }
            }
        }
    }

    /*
    Finding all cycles need different logic, it cannot be embedded into this code.
    To modify, one cannot stop once a cycle is founded,
    it needs to visit all nodes in the connected component.
     */
    public void cycleDetect(int node, int prev) {
        marked[node] = true;
        announce();
        for (int neighbor: maze.adj(node)) {
            if (neighbor != prev) {
                if (marked[neighbor]) {
                    cycleSource = neighbor;
                    edgeTo[neighbor] = node;
                    announce();
                    inCycle = true;
                    isCycle = true;
                    return;
                }
                cycleDetect(neighbor, node);
                if (inCycle) {
                    edgeTo[neighbor] = node;
                    announce();
                    if (node == cycleSource) {
                        inCycle = false;
                    }
                    return;
                }
                if (isCycle) {
                    return;
                }
            }
        }
    }
}

