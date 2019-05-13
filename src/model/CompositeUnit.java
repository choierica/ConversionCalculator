package model;

import exceptions.NegativeNumberException;
import model.Interfaces.Units;

import java.util.ArrayList;
import java.util.List;

public class CompositeUnit implements Units{


    private List<Units> units = new ArrayList<>();


    @Override
    public String doConversion(String number) throws NegativeNumberException {
        for (Units unit : units) {
            return unit.doConversion(number);
        }
        return "";
    }

    public void addUnits(Units unit) {
        units.add(unit);
    }


}
