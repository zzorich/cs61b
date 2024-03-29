package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int width;
    private int upperSite;
    private int lowSite;
    private int[] sites;
    private int sizeOfopensites = 0;
    private WeightedQuickUnionUF full;
    private WeightedQuickUnionUF perc;
    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        width = N;
        upperSite = N * N;
        lowSite = N * N + 1;
        full = new WeightedQuickUnionUF(N * N + 1);
        perc = new WeightedQuickUnionUF(N * N + 2);
        for (int i = 0; i < N; i++) {
            full.union(upperSite, i);
            perc.union(upperSite, i);
            perc.union(lowSite, N * N - 1 - i);
        }
        sites = new int[N * N];
    }
    private boolean inrange(int row, int col) {
        return row >= 0 && row < width && col >= 0 && col < width;
    }
    private int indexConvert(int row, int col) {
        if (!inrange(row, col)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return row * width + col;
    }

    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }
        int index = indexConvert(row, col);
        sites[index] = 1;
        sizeOfopensites += 1;
        if (inrange(row - 1, col) && isOpen(row - 1, col)) {
            full.union(indexConvert(row - 1, col), index);
            perc.union(indexConvert(row - 1, col), index);
        }
        if (inrange(row + 1, col) && isOpen(row + 1, col)) {
            full.union(indexConvert(row + 1, col), index);
            perc.union(indexConvert(row + 1, col), index);
        }
        if (inrange(row, col + 1) && isOpen(row, col + 1)) {
            full.union(indexConvert(row, col + 1), index);
            perc.union(indexConvert(row, col + 1), index);
        }
        if (inrange(row, col - 1) && isOpen(row, col - 1)) {
            full.union(indexConvert(row, col - 1), index);
            perc.union(indexConvert(row, col - 1), index);
        }
    }

    public boolean isOpen(int row, int col) {
        return sites[indexConvert(row, col)] == 1;
    }

    public boolean isFull(int row, int col) {
        return isOpen(row, col) && full.connected(indexConvert(row, col), upperSite);
    }
    public int numberOfOpenSites() {
        return sizeOfopensites;
    }

    public boolean percolates() {
        if (width == 1) {
            return isOpen(0, 0);
        }
        return perc.connected(upperSite, lowSite);
    }

    public static void main(String[] args) {

    }
}
