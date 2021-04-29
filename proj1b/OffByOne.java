public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int d = x - y;
        return d == 1 || d == -1;
    }
}
