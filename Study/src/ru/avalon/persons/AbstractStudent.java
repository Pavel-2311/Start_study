package ru.avalon.persons;

public abstract class AbstractStudent extends Person {
    public AbstractStudent(String name, Sex sex, String dep) {
        super(name, sex, dep, "studies");
    }
}
