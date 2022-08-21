
package ru.specialist;

public class ComLineParser {
    
    public String [] keys;
    public String [] delimeters;

    
    public enum SwitchStatus { NoError, Error, ShowUsage }; 

    public ComLineParser(String[] keys, String[] delimeters) {
        this.keys = keys;
        this.delimeters = delimeters;
    }

    public ComLineParser(String[] keys) {
         this(keys,new String []{"/", "-"});  // обьявление анонимного массива
    }
    
    public void onUsage( String errorKey){
        if (errorKey != null)System.out.println("Error key: "+ errorKey);
        
    System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
    System.out.println("   -?  показать Help файл");
    System.out.println("   -r  задать имя входного файла");
    System.out.println("   -w  выполнить вывод в указанный файл");
    }
    
    public SwitchStatus onSwitch(String key, String keyValue){
        System.out.println(key);
        System.out.println(keyValue);
        
        return SwitchStatus .NoError;
    }
    public boolean parse(String [] args){
        SwitchStatus ss = SwitchStatus.NoError;	    
        int argNum;
         for (argNum = 0; (ss == SwitchStatus.NoError) && (argNum < args.length); argNum++) {
           boolean isDelimeter = false;
            for (int n = 0; !isDelimeter && (n < delimeters.length); n++) {
               	 isDelimeter = args[argNum].regionMatches(0,delimeters[n], 0, 1);
            }
               if (isDelimeter) {
	    boolean isKey = false;
            int i;
            for (i = 0; !isKey && (i < keys.length); i++) {
                isKey = args[argNum].regionMatches(1, keys[i], 0, keys[i].length());
              
            if (isKey) break;
            }
            if (isKey) {}             
           else {
                ss= SwitchStatus.Error;
                break;
            }
               }
    }
        if (ss == SwitchStatus.ShowUsage)    onUsage(null);
        if (ss == SwitchStatus.Error)  
            onUsage((argNum == args.length) ? null : args[argNum]);
        
        return ss == SwitchStatus.NoError;  
}
}
class TestParser{

    public static void main(String[] args) {
     
       ComLineParser clp = new ComLineParser(new String []{"?", "r", "w"},new String []{"/", "-"});
      
        clp.parse(args);
    }
}