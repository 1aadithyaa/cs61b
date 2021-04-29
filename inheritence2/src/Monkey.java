public class Monkey extends Animal {
    private String name;
    public Monkey(String name) {}

    public static void main(String[] args) {
        Monkey jimmy = new Monkey("Jimmy");
        Animal limmy =  (Animal) jimmy;
        Dog kimmy = (Dog) limmy;
    }
}
