package exceptions;

import ui.ConversionApp;

import java.io.IOException;

public class AnswerNotAcceptedException extends Exception {
    ConversionApp ca = new ConversionApp();
    public AnswerNotAcceptedException(String msg) throws AnswerNotAcceptedException, NegativeNumberException, IOException, StringNotIdentifiedException {
        super(msg);
        ca.start();

    }
}
