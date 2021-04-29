public class OffByN implements CharacterComparator {
    private final int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int d = x - y;
        return d == N || d == -N;
    }
}
