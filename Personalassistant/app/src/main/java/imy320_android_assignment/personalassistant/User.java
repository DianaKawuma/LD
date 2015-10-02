package imy320_android_assignment.personalassistant;

public class User {
    String name, surname, username, password;

    public User(String name, String surname, String username, String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.surname = "";
        this.name = "";
    }

}
