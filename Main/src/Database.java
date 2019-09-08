import java.io.*;
import java.util.Scanner;

public class Database {
    private int[] id = new int[100];
    private String[] name = new String[100];
    private int[] age = new int[100];
    private int count = 0;
    private Scanner scanner;
    FileWriter fileWriter;
    FileReader fileReader;

    public Database(String path) {
        File file = new File(path);
        try {
            scanner = new Scanner(file);
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
        count = ++id[count];
    }

    int getCount() {
        return count;
    }

    void create(String name, int age) {
        String line;
        char sep = ';';
        id[count] = count;
        line = String.valueOf(id[count]) + sep;
        line += this.name[count] = name + sep;
        line += this.age[count] = age + sep;

        try {
            fileWriter = new FileWriter("Main/resources/db.txt", true);
            fileWriter.write(line + '\n');
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error! No such file or another input/output exception");
            e.printStackTrace();
        }

        System.out.println("Client has been added");
        count++;
    }

    int show() {
        int count = 0;
        System.out.println("Function 'show' has been called...");
        for (int i = 0; i < this.count; i++) {
            System.out.println(id[i] + " " + name[i] + ' ' + age[i]);
            count = i;
        }
        return ++count;
    }

    void remove() {
        System.out.println("Remove by id: ");

    }

    void update() {

    }
}
