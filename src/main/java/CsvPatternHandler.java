import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CsvPatternHandler {

    private final Path inputFilePath;
    private final Path outputDirectoryPath;
    private Set<LinePattern> patternSet;
    private List<String[]> lines;

    public CsvPatternHandler(String inputFileName, String outputDirectory) {
        this.inputFilePath = Paths.get("src", "main", "java", "putTheFileHere", inputFileName);
        this.outputDirectoryPath = Paths.get("src", "main", "java", outputDirectory);
        this.patternSet = new HashSet<>();
        this.lines = new ArrayList<>();
    }

    public void loadCSV() throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader(String.valueOf(inputFilePath)));
        lines = reader.readAll();
        lines.parallelStream().forEach(line -> {
            LinePattern linePattern = new LinePattern(line[0]);
            patternSet.add(linePattern);
        });
        reader.close();
    }

    public void printPatterns() {
        patternSet.forEach(pattern -> System.out.println(pattern.getExemplo()));
    }

    public void removePattern(String patternToExclude) throws IOException {
        LinePattern pattern = new LinePattern(patternToExclude);
        List<String[]> linesToKeep = new ArrayList<>();

        lines.forEach(line -> {
            LinePattern currentPattern = new LinePattern(line[0]);
            if (!currentPattern.equals(pattern)) {
                linesToKeep.add(line);
            }
        });

        System.out.println("Linhas com o padrão selecionado foram removidas.");
        writeCSV(linesToKeep, "exclude_operation");
    }

    public void exportPattern(String patternToExport) throws IOException {
        LinePattern pattern = new LinePattern(patternToExport);
        List<String[]> exportedLines = new ArrayList<>();

        lines.forEach(line -> {
            LinePattern currentPattern = new LinePattern(line[0]);
            if (currentPattern.equals(pattern)) {
                exportedLines.add(line);
                System.out.println("Linha exportada");
            }
        });

        System.out.println("Linhas com o padrão selecionado foram exportadas.");
        writeCSV(exportedLines, "export_operation");
    }

    private void writeCSV(List<String[]> linesToWrite, String operation) throws IOException {
        Path outputPath = Paths.get(String.valueOf(outputDirectoryPath), operation + "_file.csv");
        try (CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(outputPath)))) {
            for (String[] line : linesToWrite) {
                writer.writeNext(line);
            }
        }
    }

    public void printPatternsDetails() {
        patternSet.forEach(System.out::println);
    }
}
