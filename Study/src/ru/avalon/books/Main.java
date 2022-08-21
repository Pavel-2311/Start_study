
package ru.avalon.books;


public class Main {
    
      public static void main(String[] args) {
          // Объекты издательств
       /* Cities c1 = new Cities(" Проспект", " Москва");
        Cities c2 = new Cities(" Питер", " Санкт-Петербург");
        Cities c3 = new Cities(" БХВ", " Санкт-Петебург");
        Cities c4 = new Cities(" Диалектика", " Киев");
        c3.setCityName("Санкт-Петербург");
        c3.print();*/
         

   
        
   Books [] books = {
 new Books("Computer Science: основы программирования на Java,ООП, алгоритмы и структуры данных;",
           "Седжвик Роберт, Уэйн Кевин", 2018, "Питер"),          
 new Books("Разработка требований к программному обеспечению. 3-е издание, дополненное;", "Вигерс Карл; ", 2019, "БХВ"),
 new Books("Java. Полное руководство, 10-е издание; ","Шилдт Герберт;",2018,  "Диалектика"),  
 new Books("C/C++. Процедурное программирование;","Полубенцева М.И.;",2017, "БХВ"),  
 new Books("Конституция РФ,",2022,"Проспект")};
       
      
        Books.printAll(books);
    
}
}