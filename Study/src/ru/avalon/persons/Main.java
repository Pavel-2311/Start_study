package ru.avalon.persons;

public class Main {
    public static void main(String[] args) {
        Person[] pp = {
            new Teacher("Nick Corn", Sex.MALE, "Computer science",
                    Degree.PHD, "Software engineering"),
            new PhDStudent("Java programming",
                    "John Smith", Sex.MALE, "Computer science"),
            new RegularStudent("Anna-Maria Larsson", Sex.FEMALE, 
                    "Economic", Stage.MASTER, 1)
        };
        
        Person.printAll(pp);
    }
}
