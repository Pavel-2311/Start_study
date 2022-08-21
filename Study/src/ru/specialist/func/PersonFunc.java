
package ru.specialist.func;


public class PersonFunc {
    public String name;
    public int age;

    public PersonFunc(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    

    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
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
    
    
}
