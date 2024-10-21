import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, CsvException {

        //READ THE GIVEN FILE
        //IDENTIFY PATTERNS
        //OUTPUTS PATTERNS
        //THEN YOU CAN REMOVE OR EXPORT ONE SELECTED PATTERN

        Scanner scanner = new Scanner(System.in);
        CsvPatternHandler csvHandler = new CsvPatternHandler("okajimaBadExample.csv", "outputs");

        csvHandler.loadCSV();

        csvHandler.printPatternsDetails();

        System.out.println("O que fazer a seguir? Selecione um número: \n");
        System.out.println("1. EXCLUIR PADRÃO DE LINHA      2. EXTRAIR PADRÃO DE LINHA     3. SAIR \n");

        var selectedOption = scanner.nextInt();
        scanner.nextLine();

        if (selectedOption == 1) {
            System.out.println("Qual padrão você gostaria de remover?");
            csvHandler.printPatterns();
            String selectedPatternToExclude = scanner.nextLine();
            csvHandler.removePattern(selectedPatternToExclude);
        } else if (selectedOption == 2) {
            System.out.println("Qual padrão você gostaria de exportar?");
            csvHandler.printPatterns();
            String selectedPatternToExport = scanner.nextLine();
            csvHandler.exportPattern(selectedPatternToExport);
        } else if (selectedOption == 3) {
            System.out.println("Saindo do programa.");
            return;
        }
    }
}
