package ru.avalon.persons;

public enum Sex {
    MALE("He", "His"), 
    FEMALE("She", "Her");
    
    private String pronoun;
    private String pronounGen;

    private Sex(String pronoun, String pronounGen) {
        this.pronoun = pronoun;
        this.pronounGen = pronounGen;
    }

    public String getPronoun() {
        return pronoun;
    }

    public String getPronounGen() {
        return pronounGen;
    }
}
