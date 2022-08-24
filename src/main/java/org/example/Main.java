package org.example;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import java.util.stream.Collectors;

public class Main {
    public static final String DELIMITER = ",";

    public static void main(String[] args) throws IOException {

        InputStream stream = Main.class.getClassLoader().getResourceAsStream("sample.txt");

        assert stream != null;
        List<String> lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);
        List<Person> personList = transform(lines.subList(1, lines.size()));

    }

    private static List<Person> transform(List<String> lines) {
        return lines.stream().map(Main::toPerson).collect(Collectors.toList());
    }

    private static Person toPerson(String line) {
        String[] array = line.split(DELIMITER);
        return new Person(
                array[0],
                Integer.parseInt(array[1]),
                Float.parseFloat(array[2]),
                array[3],
                LocalDate.parse(array[4])


        );
    }
}
