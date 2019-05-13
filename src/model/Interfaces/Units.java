package model.Interfaces;

import exceptions.NegativeNumberException;

public interface Units {

    String doConversion(String number) throws NegativeNumberException;
}
