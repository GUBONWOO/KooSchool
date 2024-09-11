package animals;

abstract class Animal {
    String name ;
    public Animal(String name) {
        this.name = name;
    }
    void eat(){
        System.out.println("eat");
    }

   abstract void sound() ;
}
interface Pet{
    void play();

}
abstract class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
    }
}

class Dog extends Mammal implements Pet{
    void sound(){
        System.out.println(name +"Dog sound");
    }

    void walk(){
        System.out.println(name +"Dog walk");
    }


    public void play(){
        System.out.println(name +"Dog play");
    }
    public Dog(String name){
        super(name);
    }

}

class Cat extends Mammal implements Pet{
    void sound(){
        System.out.println(name +"Cat sound");
    }

    public void walk(){
        System.out.println(name +"Cat walk");
    }
   public void play(){
        System.out.println(name +"Cat play");
    }
    public Cat(String name){
        super(name);
    }
}

class Tiger extends Mammal implements Pet {
    void sound(){
        System.out.println(name +"Tiger sound");
    }

    public void walk(){
        System.out.println(name +"Tiger walk");
    }
    public void play() {
        System.out.println(name +"Tiger play");

    }
    public Tiger(String name) {
        super(name);
    }
}

public class Animals {
    public static void main(String[] args) {
   Dog dog = new Dog("bo");
   Cat cat = new Cat("Mo");
   Tiger tiger = new Tiger("Po");
   dog.sound();
   cat.sound();
   tiger.sound();
   dog.walk();
   cat.walk();
   tiger.walk();
   dog.play();
   cat.play();
   tiger.play();
   dog.eat();
   cat.eat();
   tiger.eat();


    }
}
