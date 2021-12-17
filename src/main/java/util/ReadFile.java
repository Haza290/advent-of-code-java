package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static List<String> toStringList(File file) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<Integer> toIntegerList(File file) {
        return toStringList(file).stream().map(Integer::parseInt).toList();
    }
}
