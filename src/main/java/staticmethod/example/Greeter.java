package staticmethod.example;

public interface Greeter {

    static Greeter createDefault() {
        return new DefaultGreeter();
    }

    public void greet();
}
