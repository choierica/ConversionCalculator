package test;

import model.NumEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNumEntry {
    private NumEntry numEntry;
    private static final int MANY = 5000;

    @BeforeEach
    public void runBefore() {
        numEntry = new NumEntry();
    }




}
