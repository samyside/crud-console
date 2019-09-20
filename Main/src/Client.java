public class Client {
    private int id;
    private String name;
    private int age;

    public Client(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Client(String[] tempArray) {
        id = Integer.parseInt(tempArray[0]);
        name = tempArray[1];
        age = Integer.parseInt(tempArray[2]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + ";" + name + ";" + age;
    }
}
