public class Monkey extends Animal{
    public Monkey(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat(){
        System.out.println("Monkey is eating");
    }

    @Override
    public void makeSound() {
        System.out.println("Monkey is chattering (makeSound)");
    }

    @Override
    public void action() {
        System.out.println("The monkey is climbing trees");
    }

    @Override
    public String toString() {
        return "Monkey" + super.toString();
    }

}
