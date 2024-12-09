public class Lion extends Animal{
    public Lion(String name, int age){
        super(name, age);
    }
    public void roar(){
        System.out.println("Lion is roaring");
    }
    @Override
    public void eat() {
        System.out.println("Lion is eating");
    }

    @Override
    public void makeSound() {
        System.out.println("Lion is roaring (makeSound)");
    }

    @Override
    public void action() {
        System.out.println("The lion is hunting");
    }

    @Override
    public String toString() {
        return "Lion" + super.toString();
    }
}
