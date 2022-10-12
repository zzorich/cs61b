package hw4.puzzle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import edu.princeton.cs.algs4.MinPQ;

public class Solver {

    private class SearchNode {
        WorldState current;
        int moves;
        SearchNode previous;
        SearchNode(WorldState state, int mvs, SearchNode pre) {
            this.current = state;
            this.moves = mvs;
            this.previous = pre;
        }
    }
    public class WSComparator implements Comparator<SearchNode> {
        private HashMap<WorldState, Integer> estgdistances = new HashMap<>();
        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            int disto1;
            int disto2;
            if (!estgdistances.containsKey(o1.current)) {
                estgdistances.put(o1.current, o1.current.estimatedDistanceToGoal());
            }
            disto1 = estgdistances.get(o1.current) + o1.moves;

            if (!estgdistances.containsKey(o2.current)) {
                estgdistances.put(o2.current, o2.current.estimatedDistanceToGoal());
            }
            disto2 = estgdistances.get(o2.current) + o2.moves;
        /*
        disto1 = o1.moves + o1.current.estimatedDistanceToGoal();
        disto2 = o2.moves + o2.current.estimatedDistanceToGoal();

         */
            if (disto1 < disto2) return -1;
            if (disto1 > disto2) return +1;
            return 0;
        }
    }

    private int moves;
    private Stack<WorldState> solution = new Stack<>();
    private MinPQ<SearchNode> fringe;
    private HashSet<WorldState> visitedStates = new HashSet<>();

    public Solver(WorldState initial) {
        SearchNode initNode = new SearchNode(initial, 0, null);
        fringe = new MinPQ<>(new WSComparator());
        fringe.insert(initNode);

        while (!fringe.isEmpty()) {
            SearchNode currNode = fringe.delMin();
            visitedStates.add(currNode.current);
            /*
            System.out.println("A new element has been poped:");
            System.out.println(currNode.current);

             */

            if (currNode.current.isGoal()) {
                moves = currNode.moves;
                while (currNode != null) {
                    solution.push(currNode.current);
                    currNode = currNode.previous;
                }
                /*
                System.out.println("Total moves is: " + moves);

                 */
                break;
            }
            for (WorldState state: currNode.current.neighbors()) {
                if ((currNode.previous != null && state.equals(currNode.previous.current))
                        || visitedStates.contains(state)) {
                    continue;
                }
                fringe.insert(new SearchNode(state, currNode.moves + 1, currNode.previous));
            }
        }
    }
    public int moves() {
        return moves;
    }
    public Iterable<WorldState> solution() {
        return solution;
    }
}
