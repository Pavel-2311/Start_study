package ru.avalon.persons;

public class Teacher extends Person {
    private Degree degree;
    private String spec;

    public Teacher(String name, Sex sex, String dep,
            Degree degree, String spec) {
        super(name, sex, dep, "teaches");
        
        this.degree = degree;
        this.spec = spec;
    }

    @Override
    public String getDetailInfo() {
        return getSex().getPronoun() + " has "
                + degree + " degree in " + spec + ".";
    }
}
