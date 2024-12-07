import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("Animal is eating");
    }

    public abstract void makeSound();

    public abstract void action();

    public void updateAnimal(){
        String newName, currentName;
        currentName = this.name;
        do{
            newName = Main.updateString(this.name, "Cập nhật tên con vật: ");
            if(currentName.equals(newName)){
                System.out.println("Duplicated!");
            }
            else{
                this.name = newName;
            }
        }while(currentName.equals(newName));
        this.age = Main.updateInt(this.age, "Cập nhật tuổi con vật: ");
    }

    @Override
    public String toString() {
        return " {" +
                "age=" + this.age +
                ", name='" + this.name + '\'' +
                '}';
    }
}
