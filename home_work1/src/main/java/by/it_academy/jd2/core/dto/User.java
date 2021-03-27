package by.it_academy.jd2.core.dto;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String age;


    public String getAge() {
        return age;
    }

    public User(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public  void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    @Override
    public String toString(){
        return "User : \n" +
                getFirstName() + " " +
                getLastName() + " " +
                getAge() + " years old";
    }
}
