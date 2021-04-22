public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
     }
    private IntNode first;
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }
}