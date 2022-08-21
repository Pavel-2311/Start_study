package ru.avalon.country;

public class Country {
    private String name;
    private float square;
    private int population;
    private String capitalName;
    private int capitalPopulation;

    public Country(String name, float square, int population) {
        this(name, square, population, null, 0);
    }

    public Country(String name, float square, int population, 
            String capitalName, int capitalPopulation) {
        setName(name);
        setSquare(square);
        setPopulation(population);
        setCapitalName(capitalName);
        setCapitalPopulation(capitalPopulation);
    }
    
    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public int getCapitalPopulation() {
        return capitalPopulation;
    }

    public void setCapitalPopulation(int capitalPopulation) {
        if(capitalPopulation < 0)
            throw new IllegalArgumentException("capital population can't be less than zero.");
        this.capitalPopulation = capitalPopulation;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null)
            throw new IllegalArgumentException("country name can't be null.");
        
        this.name = name;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        if(square <= 0)
            throw new IllegalArgumentException("square can't be less than zero.");
        
        this.square = square;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        if(population < 0) {
            throw new IllegalArgumentException("population can't be less than zero.");
        }
        this.population = population;
    }
    
    public float getDensity() {
        return population / square;
    }

    public void print() {
        System.out.println(name + "; square is " + square
            + "; population is " + population);
        if(capitalName != null)
            System.out.println("Capital is " + capitalName + " with population "
                + capitalPopulation + ".");
    }
    
    public static void printAll(Country[] countries) {
        for(Country c: countries) {
            c.print();
            System.out.println();
        }
    }
}
