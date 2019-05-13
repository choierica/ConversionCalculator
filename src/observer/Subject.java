package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<ConversionObserver> observers = new ArrayList<>();

    public void addObserver(ConversionObserver conversionObserver){
        if(!observers.contains(conversionObserver)){
            observers.add(conversionObserver);
        }
    }


    public void notifyObservers(String s){
        for (ConversionObserver observer : observers){
            observer.update(s);
        }
    }
}


