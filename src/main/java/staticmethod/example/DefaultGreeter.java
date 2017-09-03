package staticmethod.example;

class DefaultGreeter implements Greeter {
    @Override
    public void greet() {
        System.out.println("Hello World!");
    }
}
