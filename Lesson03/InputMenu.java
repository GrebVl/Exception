package Lesson03;


import Lesson03.Human.Human;
import Lesson03.Human.StringParsingException;


import java.util.Scanner;

public class InputMenu {
    private static Scanner scn;

    public InputMenu() {
    }

    public Human inputMenu() throws StringParsingException {
        Human people = new Human();

        while(true) {
            try {
                people.setFullName(this.inputFullName());
                people.setDateBirth(this.inputDateBirth());
                people.setCellPhone(this.inputCellPhone());
                people.setFloor(this.inputFloor());
                return people;
            } catch (StringParsingException var3) {
                System.out.println(var3.getMessage());
            }
        }
    }

    public String[] inputFullName() {
        while(true) {
            try {
                System.out.println("Введите Фамилию Имя Отчество, через пробел:");
                String[] fullName = this.convertingString(scn.nextLine().trim());
                return fullName;
            } catch (StringParsingException var3) {
                System.out.println(var3.getMessage());
            }
        }
    }

    public int[] inputDateBirth() {
        int[] dateBirth = new int[3];

        while(true) {
            try {
                System.out.println("Введите Дату рождения формата ДД.ММ.ГГГГ, через точеку:");
                String[] arrayDateBirth = this.convertingString(scn.nextLine().trim());

                for(int i = 0; i < 3; ++i) {
                    dateBirth[i] = parserElement(arrayDateBirth[i], i);
                }

                return dateBirth;
            } catch (StringParsingException var4) {
                System.out.println(var4.getMessage());
            }
        }
    }

    public int[] inputCellPhone() {
        while(true) {
            System.out.println("Введите сотовый телефон, цифрами без разделтителей: ");

            try {
                int[] cellPhone = this.parserInt(scn.nextLine().trim());
                return cellPhone;
            } catch (StringParsingException var3) {
                System.out.println(var3.getMessage());
            }
        }
    }

    public char inputFloor() throws StringParsingException {
        while(true) {
            try {
                System.out.println("Введите пол,\nсимвол латиницей f или m: ");
                String str = scn.nextLine();
                if (str.equals("")) {
                    throw new StringParsingException("Строка не можбыть пустой", str, 0);
                }

                char inputFloor = str.charAt(0);
                if (inputFloor != 'f' && inputFloor != 'm') {
                    throw new StringParsingException("Введено не верное значение", str, 0);
                }

                return inputFloor;
            } catch (StringParsingException var3) {
                System.out.println(var3.getMessage());
            }
        }
    }

    public int[] parserInt(String str) throws StringParsingException {
        if (str.length() != 13) {
            throw new StringParsingException("Номер в векден не полностью,\nНомер должен содержать 13 цифр\n(пример 9998887776655)\n", str, 0);
        } else if (str.equals("")) {
            throw new StringParsingException("Строка не можбыть пустой", str, 0);
        } else {
            int[] resalt = new int[13];

            for(int k = str.length() - 1; k >= 0; --k) {
                resalt[k] = parserElement(String.valueOf(str.charAt(k)), k);
            }

            return resalt;
        }
    }

    public String[] convertingString(String str) throws StringParsingException {
        if (str.equals("")) {
            throw new StringParsingException("Строка не можбыть пустой", str, 0);
        } else {
            char[] sign = new char[]{' ', '.'};
            if (str.indexOf(sign[0]) == -1 && str.indexOf(sign[1]) == -1) {
                throw new StringParsingException("Введены не все данные ", str, 0);
            } else {
                String[] resalt;
                if (str.indexOf(sign[0]) != -1) {
                    resalt = parserString(str, sign[0]);
                } else {
                    resalt = parserString(str, sign[1]);
                }

                for(int i = 0; i < resalt.length; ++i) {
                    if (resalt[i] == null) {
                        throw new StringParsingException("Введены не все данные ", str, i);
                    }
                }

                return resalt;
            }
        }
    }

    static String[] parserString(String str, char sign) {
        String[] resalt = new String[3];
        int index = str.indexOf(sign);
        resalt[0] = str.substring(0, index);

        for(int i = index + 1; i < str.length(); ++i) {
            if (str.charAt(i) == sign) {
                resalt[1] = str.substring(index + 1, i);
                resalt[2] = str.substring(i + 1);
            }
        }

        return resalt;
    }

    static int parserElement(String element, int index) throws StringParsingException {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException var3) {
            throw new StringParsingException(String.format("Некоректный фомат данных %s под индексом %d", element, index), element, index);
        }
    }

    static {
        scn = new Scanner(System.in);
    }
}

