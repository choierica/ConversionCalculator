package ui;


import exceptions.AnswerNotAcceptedException;
import exceptions.NegativeNumberException;
import exceptions.StringNotIdentifiedException;
import model.Conversion;
import java.io.IOException;



public class ConversionApp {


    public void start() throws IOException {
        Conversion c = new Conversion();
        c.scanOption();
    }

    public static void main(String[] args) throws IOException, NegativeNumberException, AnswerNotAcceptedException, StringNotIdentifiedException {
        ConversionApp ca = new ConversionApp();
        ca.start();
    }
}
