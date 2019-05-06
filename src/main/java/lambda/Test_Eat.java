package lambda;

public class Test_Eat {
    public static void main(String[] args) {
        Person person = new Person() {
            @Override
            public void eat() {
                System.out.println("123");
            }
        };
        person.eat();
    }
}
