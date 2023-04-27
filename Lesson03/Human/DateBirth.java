package Lesson03.Human;

public class DateBirth {
    private int day;
    private int month;
    private int year;

    public DateBirth() {
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "day=" + this.day + ", month=" + this.month + ", year=" + this.year;
    }
}

