
package ru.specialist.generics;

//public class ReadOnlyStorage<T> { // <T> типизировать можно вообще любым типом

public class ReadOnlyStorage<T extends Comparable<? super T>, T1, T2> { //ограничение по типизации
    // Comparable типизирован либо Т либо любым из его родителей
    private T data;

    public ReadOnlyStorage(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
    public boolean isGreater(T x){
        return data.compareTo(x)>0;
    }
    
}
