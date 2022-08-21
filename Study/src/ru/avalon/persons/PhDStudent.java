package ru.avalon.persons;

public class PhDStudent extends AbstractStudent {
    private String thesisTopic;

    public PhDStudent(String thesisTopic, String name, Sex sex, String dep) {
        super(name, sex, dep);
        this.thesisTopic = thesisTopic;
    }

    @Override
    public String getDetailInfo() {
        return getSex().getPronounGen() + " thesis title is \""
                + thesisTopic + "\".";
    }
}
