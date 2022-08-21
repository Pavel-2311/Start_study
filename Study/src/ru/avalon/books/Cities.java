
package ru.avalon.books;



public class Cities {
    
    public String cityName; // название города
    public String publishingName;// название издательства
    

   

    public Cities(String publishingName, String cityName ) {
        setCityName (cityName);
        this.publishingName=publishingName;
    }

    public Cities(String publishingName) {
        this(publishingName,null);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
         if(cityName == null)
            throw new IllegalArgumentException("city name can't be null.");
         if(cityName == "Санкт-Петебург"){
             cityName="Санкт-Петербург";}

        this.cityName = cityName;
    }

   /* public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
         if(publishingName == null)
            throw new IllegalArgumentException("publishing name can't be null.");
        
        this.publishingName = publishingName;
    }*/

 public void print() {
        System.out.println("Издательство: "+ publishingName + " , " + cityName);
 }
    
}
