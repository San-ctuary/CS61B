public class Dog {
    private int size;

    public Dog(int s) {
        size = s;
    }

    /** Makes a noise. */
    public String noise() {
        if (size < 10) {
            return "yip";
        } 
        return "bark";
    }

    public static void main(String[] args) {
        System.out.println(new Dog(4).noise());

    }
}
