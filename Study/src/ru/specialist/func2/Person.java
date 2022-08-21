package ru.specialist.func2;


import java.util.*;

public class Person {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Имя: " + name+ "возраст: " + age);
    }

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Павел ", 37),
                new Person("Юля ", 32),
                new Person("Алиса ", 9),
                new Person("Дима ", 44),
                new Person("Катя ", 41),
                new Person("Аля ", 40));
        
      //  for (Person p : persons) {
         //   System.out.println(p);}
            
            persons.stream() // методом stream создаем конвейер
                    .parallel()
                    .filter(p ->{
                        System.out.println(Thread.currentThread().getName());
                        return p.age>=18;
                            })// сначала фильтруем
                    .sequential()
                    .sorted((p1,p2) -> p1.age-p2.age)// потому что сортировка затратнее
                    .map(p-> p.name)
                    .forEach(System.out::println);
            
        
    }
}
