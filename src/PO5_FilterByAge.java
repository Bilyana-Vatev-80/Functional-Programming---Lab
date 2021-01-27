import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PO5_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        String criteria = scanner.nextLine();
        int ageCriteria = Integer.parseInt(scanner.nextLine());

        Predicate<Person> ageFilter = createAgeFilter(criteria, ageCriteria);
        String formatOption = scanner.nextLine();
        Function<Person, String> format = creatFormatter(formatOption);
        System.out.println(people.stream()
                .filter(ageFilter)
                .map(format)
                .collect(Collectors.joining(System.lineSeparator())));


    }

    private static Function<Person, String> creatFormatter(String formatOption) {
        if (formatOption.equals("name")) {
            return p -> p.name;
        } else if (formatOption.equals("age")) {
            return p -> String.valueOf(p.age);
        }
        return p -> p.name + " - " + p.age;
    }

    private static Predicate<Person> createAgeFilter(String criteria, int agerCriteria) {
        if (criteria.equals("older")) {
            return p -> p.age >= agerCriteria;
        }
        return p -> p.age <= agerCriteria;
    }

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
