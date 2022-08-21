package ru.avalon.persons;

public class RegularStudent extends AbstractStudent {
    private Stage stage;
    private int course;

    public RegularStudent(String name, Sex sex, String dep, 
            Stage stage, int course) {
        super(name, sex, dep);
        this.stage = stage;
        this.course = course;
    }

    @Override
    public String getDetailInfo() {
        return getSex().getPronoun() + " is " + course
                + "'th year " + stage + " student.";
    }
}
