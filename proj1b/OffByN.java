public class OffByN implements CharacterComparator{
    private static int difference;

    public OffByN(int N) {
        this.difference = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return diff == difference || diff == -difference;
    }
}
