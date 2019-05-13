package model;

import exceptions.NegativeNumberException;
import model.Interfaces.Units;

import java.text.DecimalFormat;

public class Meter implements Units {

    public Meter(String number) {

    }

    public String doConversion(String number) throws NumberFormatException, NegativeNumberException {
        Double result = Double.parseDouble(number) * 3.28;
        DecimalFormat df = new DecimalFormat("#.##");
        isPositive(result);
        return (df.format(result));
    }


    public void isPositive(Double number) throws NegativeNumberException {
        if (number <= 0){
            throw new NegativeNumberException("");
        }
    }
}
