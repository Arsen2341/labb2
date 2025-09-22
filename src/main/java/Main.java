package mainapp;

import entities.Student;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть кількість студентів: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        // Введення студентів
        for (int i = 0; i < n; i++) {
            System.out.println("\nСтудент " + (i + 1) + ":");
            System.out.print("Прізвище: ");
            String lastName = sc.nextLine();
            System.out.print("Ім'я: ");
            String firstName = sc.nextLine();
            System.out.print("По батькові: ");
            String middleName = sc.nextLine();

            System.out.print("Рік народження: ");
            int year = sc.nextInt();
            System.out.print("Місяць: ");
            int month = sc.nextInt();
            System.out.print("День: ");
            int day = sc.nextInt();
            sc.nextLine();

            LocalDate birthDate = LocalDate.of(year, month, day);

            System.out.print("Адреса: ");
            String address = sc.nextLine();
            System.out.print("Телефон: ");
            String phone = sc.nextLine();
            System.out.print("Факультет: ");
            String faculty = sc.nextLine();
            System.out.print("Курс: ");
            int course = sc.nextInt();
            sc.nextLine();
            System.out.print("Група: ");
            String group = sc.nextLine();

            students[i] = new Student(i + 1, lastName, firstName, middleName,
                    birthDate, address, phone, faculty, course, group);
        }

        int choice;
        do {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Список студентів заданого факультету");
            System.out.println("2. Список студентів, які народились після року");
            System.out.println("3. Список студентів заданої групи");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть факультет: ");
                    String fac = sc.nextLine();
                    for (Student s : students) {
                        if (s.getFaculty().equalsIgnoreCase(fac)) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Введіть рік: ");
                    int y = sc.nextInt();
                    sc.nextLine();
                    for (Student s : students) {
                        if (s.getBirthDate().getYear() > y) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Введіть групу: ");
                    String g = sc.nextLine();
                    for (Student s : students) {
                        if (s.getGroup().equalsIgnoreCase(g)) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Вихід з програми...");
                    break;

                default:
                    System.out.println("Невірний вибір!");
            }
        } while (choice != 0);
    }
}
