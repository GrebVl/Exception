package Lesson03.Human;


public class FullName {
    private String surname;
    private String name;
    private String patronymic;

    public FullName() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    public String toString() {
        return String.format("%s %s %s", this.surname, this.name, this.patronymic);
    }
}

