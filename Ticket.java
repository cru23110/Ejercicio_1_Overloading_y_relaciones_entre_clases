import java.util.Random;

public class Ticket {
    private int number;
    private int a;
    private int b;

    public Ticket() {
        Random random = new Random();
        this.number = random.nextInt(15000) + 1;
        this.a = random.nextInt(15000) + 1;
        this.b = random.nextInt(15000) + 1;
    }

    public int getNumber() {
        return number;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}