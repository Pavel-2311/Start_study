
package ru.specialist.exception;


public class MyException extends Exception{
    
  private int invalidData;

    public int getInvalidData() {
        return invalidData;
    }

    public MyException(String arg0, int getInvalidData) {
        super(arg0);
        this.invalidData = invalidData;
    }

    public MyException(String arg0, int getInvalidData, Throwable cause) {
        super(arg0, cause);
        this.invalidData = invalidData;
    }

  
    
}
