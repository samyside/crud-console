import java.util.Scanner;

public class Init {

    public static void main(String[] args) {
        final String FILENAME = "Main/resources/db.txt";

        Database db = new Database(FILENAME);
        Init init = new Init();
        do {
            System.out.print(" >_ ");
        }
        while (init.doCommand(db));
        System.out.println("Goodbye!");
    }

    private boolean doCommand(Database db) {
        String command = new Scanner(System.in).nextLine();

        switch (command) {
            case "show":
                System.out.println("total: " + db.show());
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

