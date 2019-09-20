import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private static int lastID;
    private Scanner scanner;
    FileWriter fileWriter;
    FileReader fileReader;

    private List<Client> clients;

    public Database(String path) {
        File file = new File(path);

        clients = new ArrayList<>();

        try {
            String[] tempArray = new String[3];
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                tempArray = line.split(";");
                clients.add(new Client(tempArray));
            }
            lastID = Integer.parseInt(tempArray[0]);
        } catch (FileNotFoundException | IndexOutOfBoundsException e) {
            System.out.println(
                    "Error! Couldn't find the file database.\n" +
                    "More info:\n" +
                    "========================");
            e.printStackTrace();
            System.out.println("========================");
        }
    }

    int getLastID() {
        return lastID;
    }

    void create(String name, int age) {
        lastID++;

        Client newClient =new Client(lastID, name, age);
        clients.add(newClient);
        try {
            fileWriter = new FileWriter("Main/resources/db.txt", true);
            fileWriter.write(newClient.toString() + '\n');
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error! No such file or another input/output exception");
        }

        System.out.println("Client has been added");
    }

    int show() {
        int count = 0;

        for (Client client : clients) {
            System.out.println(client.toString());
            count++;
        }
        return count;
    }

    void remove() {
        System.out.println("Remove by id: ");

    }

    void update() {

    }
}
