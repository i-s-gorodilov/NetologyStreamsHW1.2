import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        // Генерация 10 миллионов случайных объектов Person
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        // Найти количество несовершеннолетних
        long countOfMinors = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + countOfMinors);

        // Получить список фамилий призывников
        List<String> draftDodgerLastNames = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN && person.getAge() >= 18 && person.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Список фамилий призывников: " + draftDodgerLastNames);

        // Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием
        List<Person> potentialEmployees = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> (person.getSex() == Sex.WOMAN && person.getAge() >= 18 && person.getAge() <= 60)
                        || (person.getSex() == Sex.MAN && person.getAge() >= 18 && person.getAge() <= 65))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("Список потенциально работоспособных людей с высшим образованием: ");
        potentialEmployees.forEach(System.out::println);
    }
}
