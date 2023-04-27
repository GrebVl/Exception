package Lesson03.Human;

public class CellPhone {
    private int[] phoneNumber;

    public CellPhone() {
    }

    public int[] getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        StringBuilder strBild = new StringBuilder();
        strBild.append("Номер телефона +7");

        for(int i = 0; i < this.phoneNumber.length; ++i) {
            strBild.append(this.phoneNumber[i]);
        }

        return String.format("%s", strBild);
    }
}
