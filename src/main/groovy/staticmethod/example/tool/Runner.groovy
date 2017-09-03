package staticmethod.example.tool

import staticmethod.example.Greeter

class Runner {
    static void main(String[] args) {
        def greeter = Greeter.createDefault()
        greeter.greet()
    }
}
