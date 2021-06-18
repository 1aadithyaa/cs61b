public class Quick {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        System.out.println(sad.removeLast());
        sad.addFirst(0);
        System.out.println(sad.removeFirst());
    }
}
