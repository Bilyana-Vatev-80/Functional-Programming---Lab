import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class PO2_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> getCountStr = arr -> String.format("Count = %d", numbers.length);

        System.out.println(getCountStr.apply(numbers));

        Function<int[], String> getSumStr = arr -> {
            return "Sum = " + Arrays.stream(arr).sum();
        };

        System.out.println(getSumStr.apply(numbers));
    }
}
