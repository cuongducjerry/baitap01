public class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }
    public void trumpet(){
        System.out.println("Elephant is trumpeting");
    }
    @Override
    public void eat() {
        System.out.println("Elephant is eating");
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant is trumpeting (makeSound)");
    }

    @Override
    public void action() {
        System.out.println("The elephant is spraying water");
    }

    @Override
    public String toString() {
        return "Elephant" + super.toString();
    }

}
