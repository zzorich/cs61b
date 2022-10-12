package hw4.puzzle;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBoard {
    @Test
    public void verifyImmutability() {
        int r = 2;
        int c = 2;
        int[][] x = new int[r][c];
        int cnt = 0;
        for (int i = 0; i < r; i += 1) {
            for (int j = 0; j < c; j += 1) {
                x[i][j] = cnt;
                cnt += 1;
            }
        }
        Board b = new Board(x);
        assertEquals("Your Board class is not being initialized with the right values.", 0, b.tileAt(0, 0));
        assertEquals("Your Board class is not being initialized with the right values.", 1, b.tileAt(0, 1));
        assertEquals("Your Board class is not being initialized with the right values.", 2, b.tileAt(1, 0));
        assertEquals("Your Board class is not being initialized with the right values.", 3, b.tileAt(1, 1));

        x[1][1] = 1000;
        assertEquals("Your Board class is mutable and you should be making a copy of the values in the passed tiles array. Please see the FAQ!", 3, b.tileAt(1, 1));
    }

    @Test
    public void distances() {
        int[][] tiles = new int[3][3];
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j] = count;
                count++;
            }
        }
        tiles[2][2] = 0;
        Board board = new Board(tiles);
        assertTrue(board.isGoal());
    }

    @Test
    public void testNeighbour() {
        int[][] tiles = {{5, 2, 1}, {4, 8, 3}, {7, 0, 6}};
        Board board = new Board(tiles);
        for (WorldState child: board.neighbors()) {
            child = (Board) child;
            System.out.println(child);
        }
    }
}