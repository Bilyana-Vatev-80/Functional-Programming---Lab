import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PO1_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] string = scanner.nextLine().split(", ");

        String output = Arrays.stream(string)
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);

        if (output.length() != 0) {
            String secondOutput = Arrays.stream(output.split(", "))
                    .mapToInt(Integer::parseInt)
                    .filter(e -> e % 2 == 0)
                    .sorted()
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println(secondOutput);

        }
    }
}

