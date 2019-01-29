package test;
import model.ConversionHistory;
import model.Interfaces.Saving;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSaving {

    Saving saving = new ConversionHistory();
    List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));

    public TestSaving() throws IOException {
    }


    @Test
    public void testSaving() throws IOException {
        saving.save("Blah Blah");
        if (lines.size() == 0 ) {
            assertEquals(lines.size(), 0 );
        }
        else
            assertEquals("Blah Blah", (lines.get(lines.size() - 1)));
    }



}
