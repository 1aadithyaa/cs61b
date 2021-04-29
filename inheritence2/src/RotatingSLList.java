public class RotatingSLList<Item> extends SLList<Item> {
    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rs1 = new RotatingSLList<>();
        rs1.addLast(1);
        rs1.addLast(2);
        rs1.addLast(3);
        rs1.addLast(4);
        rs1.addLast(5);

        rs1.rotateRight();
        rs1.rotateRight();
        rs1.rotateRight();

    }
}
