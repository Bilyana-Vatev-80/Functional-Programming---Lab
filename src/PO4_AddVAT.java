import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class PO4_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> vatDder = val -> val * 1.20;

        System.out.println("Prices with VAT: ");

        String vat = Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> String.format("%.2f", vatDder.apply(Double.parseDouble(e))))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(vat);


    }
}
