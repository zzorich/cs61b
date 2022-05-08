public class Test {
    public static void main(String[] args) {
        Cat c = new Cat("cc", 10);
        Animal a = new Animal("aa", 11);
        a.greet();
        c.greet();
        c = (Cat) a;
        c.greet();
    }
}
