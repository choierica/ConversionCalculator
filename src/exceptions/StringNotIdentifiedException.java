package exceptions;

import model.Convert;

import java.io.IOException;

public class StringNotIdentifiedException extends Exception {
    Convert c = new Convert();
    public StringNotIdentifiedException(String msg) throws IOException, StringNotIdentifiedException, NegativeNumberException {
        super(msg);
    }
}
