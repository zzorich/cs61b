package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;
import java.util.Objects;

public class Board implements WorldState {
    private int size;
    private int[][] titles;
    private static int BLANK = 0;

    public Board(int[][] tiles) {
        size = tiles.length;
        this.titles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.titles[i][j] = tiles[i][j];
            }
        }
    }
    public int tileAt(int i, int j) {
        if (i >= size || i < 0 || j >= size || j < 0) {
            throw new IndexOutOfBoundsException("i or j should be within range.");
        }
        return titles[i][j];
    }
    public int size() {
        return size;
    }

    public int hamming() {
        int dist = 0;
        int count = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (titles[i][j] != count && titles[i][j] != BLANK) {
                    dist++;
                }
                count++;
            }
        }
        return dist;
    }
    public int manhattan() {
        int dist = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (titles[i][j] != BLANK) {
                    int title = titles[i][j] - 1;
                    int xPos = title / size;
                    int yPos = title - size * xPos;
                    dist += Math.abs(xPos - i) + Math.abs(yPos - j);
                }
            }
        }
        return dist;
    }
    @Override
    public int estimatedDistanceToGoal() {
        return manhattan();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        if (this.size != board.size()) return false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (titles[i][j] != board.tileAt(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return size + titles[0][0]; //trival hash for performance
    }

    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }

    /** Returns the string representation of the board. 
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
