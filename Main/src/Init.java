import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Init {

    public static void main(String[] args) throws FileNotFoundException {
        final String FILENAME = "Main/resources/db.txt";
        File file = new File(FILENAME);
        Scanner scanner = new Scanner(file);
        String line;

        Database db = new Database();
        Scanner inputConsole = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            System.out.println(line);
        }
        do {
            System.out.print(" >_ ");
        }
        while (doCommand(inputConsole, db));
        System.out.println("Goodbye!");
    }

    private static boolean doCommand(Scanner input, Database db) {
        String command = input.nextLine();

        switch (command) {
            case "show":
                db.show();
                break;
            case "create":
                Scanner scanner = new Scanner(System.in);
                System.out.print("name: ");
                String name = scanner.nextLine();
                System.out.print("age: ");
                try {
                    int age = Integer.parseInt(scanner.nextLine());
                    db.create(name, age);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Not a number");
                    e.printStackTrace();
                }
                break;
            case "count":
                System.out.println(db.getCount());
                break;
            case "exit":
                return false;
            default:
                System.out.println("Error! Wrong command: '" + command + "'");
                break;
        }
        return true;
    }
}

class Database {
    private int[] id = new int[100];
    private String[] name = new String[100];
    private int[] age = new int[100];
    private int count = 0;

    Database() {
        try {
            Scanner scanner = new Scanner(new File("Main/resources/db.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tempArray = line.split(";");
                int countTempArray = 0;
                id[count] = Integer.parseInt(tempArray[countTempArray++]);
                name[count] = tempArray[countTempArray++];
                age[count] = Integer.parseInt(tempArray[countTempArray]);
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Couldn't find the file database.");
        }
    }

    int getCount() {
        return count;
    }

    void create(String name, int age) {
        id[count] = count;
        this.name[count] = name;
        this.age[count] = age;
        System.out.println("Client has been added");
        count++;
    }

    void show() {
        System.out.println("Function 'show' has been called...");
        for (int i = 0; i < count; i++) {
            System.out.println(id[i] + " " + name[i] + ' ' + age[i]);
        }
    }
}