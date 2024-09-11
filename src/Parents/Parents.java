package Parents;

interface Animal{
    void eat();
    void sound();
    default void walk(){
        System.out.println("walk");
    }
}

class Dog implements Animal{
    @Override
    public void sound() {
        System.out.println("Dog sound");
    }
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }

    public void walk() {
        System.out.println("Dog walk");}
}

class Cat implements Animal{
    @Override
    public void sound() {
        System.out.println("Cat sound");
    }
    public void eat() {
        System.out.println("Cat eat");
    }
}

public class Parents {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.sound();
        cat.eat();

    }
}