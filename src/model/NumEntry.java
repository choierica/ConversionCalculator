package model;
import observer.ConversionObserver;
import observer.Subject;

import java.io.IOException;
import java.util.ArrayList;


public class NumEntry implements ConversionObserver{
    private String unit = "";
    private Double operands;
    private ConversionHistory ch = new ConversionHistory();
    private Double result = 0.0;
    private String tounit = "";

    //EFFECTS:  returns
    public String toString(){
        return operands+ unit + " equals "+result + tounit;
    }

    @Override
    public void update(ConversionObserver c){
        System.out.println("Yay! Successfully converted " +  operands + unit + " to " + result + tounit);
    }

}


