package builder;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        System.out.println("Возраст мамы известен: " + mom.hasAge());
        System.out.println("Текущий город жительства мамы известен: " + mom.hasAddress());
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Person unknownAgeAndAddress = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .build();
        System.out.println("Возраст человека известен: " + unknownAgeAndAddress.hasAge());
        System.out.println("Текущий город жительства известен: " + unknownAgeAndAddress.hasAddress());
        System.out.println(unknownAgeAndAddress.toString());
    }
}
