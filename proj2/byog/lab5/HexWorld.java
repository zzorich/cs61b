package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import javax.swing.text.Position;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    private static class Position{
        int xPos;
        int yPos;

        public Position(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }
    }

    public static void addHexagon(TETile[][] world, int size, Position position, TETile t) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 3 * size - 2 - 2 * i; j++) {
                int xPos = position.xPos + i + j;
                int dyPos = position.yPos + i;
                int uyPos = position.yPos - i -1;
                world[xPos][dyPos] = t;
                world[xPos][uyPos] = t;
            }
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        Position position= new Position(10,10);
        addHexagon(world, 4, position, Tileset.FLOWER);
        ter.renderFrame(world);
    }

}
