package model;
import exceptions.NegativeNumberException;
import exceptions.StringNotIdentifiedException;
import observer.Subject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Convert extends Subject {

    public String meter(String number) throws NumberFormatException, NegativeNumberException {
        Double result = Double.parseDouble(number) * 3.28;
        DecimalFormat df = new DecimalFormat("#.##");
        isPositive(result);
        return (df.format(result));
    }

    public String foot(String number) throws NumberFormatException, NegativeNumberException {
        Double result = Double.parseDouble(number) * 0.3048;
        DecimalFormat df = new DecimalFormat("#.##");
        isPositive(result);
        return df.format(result);
    }


    //REQUIRES:
    //MODIFIES:
    //EFFECTS: returns true if the number is positive, false otherwise.
    public void isPositive(Double number) throws NegativeNumberException {
        if (number <= 0){
            throw new NegativeNumberException("");
        }

    }


}
