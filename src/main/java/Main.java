import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[10];

        try {
            File file = new File("src/students.txt");
            System.out.println("Шукаю файл за шляхом: " + file.getAbsolutePath());
            Scanner fileScanner = new Scanner(file, "UTF-8");

            int i = 0;
            while (fileScanner.hasNextLine() && i < 10) {
                String lastName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String middleName = fileScanner.nextLine();

                int year = Integer.parseInt(fileScanner.nextLine());
                int month = Integer.parseInt(fileScanner.nextLine());
                int day = Integer.parseInt(fileScanner.nextLine());
                LocalDate birthDate = LocalDate.of(year, month, day);

                String address = fileScanner.nextLine();
                String phone = fileScanner.nextLine();
                String faculty = fileScanner.nextLine();
                int course = Integer.parseInt(fileScanner.nextLine());
                String group = fileScanner.nextLine();

                students[i] = new Student(i + 1, lastName, firstName, middleName,
                        birthDate, address, phone, faculty, course, group);
                i++;
            }

            fileScanner.close();
            System.out.println("Дані успішно зчитано з файлу!");

        } catch (FileNotFoundException e) {
            System.out.println("Файл students.txt не знайдено!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Список студентів заданого факультету");
            System.out.println("2. Список студентів, які народились після заданого року");
            System.out.println("3. Список навчальної групи");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть факультет: ");
                    String fac = sc.nextLine();
                    System.out.println("Студенти факультету " + fac + ":");
                    boolean found1 = false;
                    for (Student s : students) {
                        if (s.getFaculty().equalsIgnoreCase(fac)) {
                            System.out.println(s);
                            found1 = true;
                        }
                    }
                    if (!found1) {
                        System.out.println("Студентів з такого факультету не знайдено.");
                    }
                    break;

                case 2:
                    System.out.print("Введіть рік: ");
                    int y = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Студенти, які народились після " + y + " року:");
                    boolean found2 = false;
                    for (Student s : students) {
                        if (s.getBirthDate().getYear() > y) {
                            System.out.println(s);
                            found2 = true;
                        }
                    }
                    if (!found2) {
                        System.out.println("Студентів, які народились після " + y + " року, не знайдено.");
                    }
                    break;

                case 3:
                    System.out.print("Введіть групу: ");
                    String g = sc.nextLine();
                    System.out.println("Студенти групи " + g + ":");
                    boolean found3 = false;
                    for (Student s : students) {
                        if (s.getGroup().equalsIgnoreCase(g)) {
                            System.out.println(s);
                            found3 = true;
                        }
                    }
                    if (!found3) {
                        System.out.println("Студентів з такої групи не знайдено.");
                    }
                    break;

                case 0:
                    System.out.println("Вихід з програми...");
                    break;

                default:
                    System.out.println("Невірний вибір!");
            }
        } while (choice != 0);

        sc.close();
    }
}