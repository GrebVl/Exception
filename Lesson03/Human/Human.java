package Lesson03.Human;

public class Human {
    private FullName fullName = new FullName();
    private DateBirth dateBirth = new DateBirth();
    private CellPhone cellPhone = new CellPhone();
    private Floor floor = new Floor();

    public Human() {
    }

    public FullName getFullName() {
        return this.fullName;
    }

    public void setFullName(String[] fullName) {
        this.fullName.setSurname(fullName[0]);
        this.fullName.setName(fullName[1]);
        this.fullName.setPatronymic(fullName[2]);
    }

    public DateBirth getDateBirth() {
        return this.dateBirth;
    }

    public void setDateBirth(int[] dateBirth) {
        this.dateBirth.setDay(dateBirth[0]);
        this.dateBirth.setMonth(dateBirth[1]);
        this.dateBirth.setYear(dateBirth[2]);
    }

    public CellPhone getCellPhone() {
        return this.cellPhone;
    }

    public void setCellPhone(int[] cellPhone) {
        this.cellPhone.setPhoneNumber(cellPhone);
    }

    public Floor getFloor() {
        return this.floor;
    }

    public void setFloor(char floor) {
        this.floor.setFloor(floor);
    }

    public String toString() {
        return String.format("%s %s %s %s\n", this.fullName.toString(), this.dateBirth.toString(), this.cellPhone.toString(), this.floor.toString());
    }
}


