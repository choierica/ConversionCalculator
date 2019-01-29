package model;
import model.Interfaces.Saving;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ConversionHistory implements Saving {

    public void clear() throws IOException {
        PrintWriter writer = new PrintWriter("outputfile.txt","UTF-8");
        writer.print("");
        writer.close();
    }


    public void save(String operation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");

        lines.add(operation);
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }

}
