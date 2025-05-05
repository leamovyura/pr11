import java.io.*;
import java.util.Scanner;

public class Main {

    static final String FILE_NAME = "file.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nМеню:");
            System.out.println("1 Записати рядок у файл");
            System.out.println("2 Прочитати вміст файлу");
            System.out.println("3 Вийти");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                writeLine(scanner);
            } else if (choice.equals("2")) {
                readFile();
            } else if (choice.equals("3")) {
                exit = true;
                System.out.println("Вихід");
            } else {
                System.out.println("Невірний вибір.");
            }
        }
        scanner.close();
    }

    static void writeLine(Scanner scanner) {
        System.out.println("Введіть рядок для запису:");
        String line = scanner.nextLine();

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(line + "\n");
            System.out.println("Рядок записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
    }

    static void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("Вміст файлу:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено.");
        } catch (IOException e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }
    }
}
