import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 * и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 * <p>
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */


public class Lesson02 {

    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        //test();

        while (true) {
            try {
                System.out.print("Введите число: ");
                String number = scn.nextLine();
                System.out.println("Вы ввели: " + convertingStringNumber(number));
                return;
            } catch (MyStringParsingException e) {
                System.out.println(e.getMessage());
            }
        }

    }



    /**
     * Метоот перевода строки в float
     *
     * @param str конвертируемая строка
     * @return
     * @throws MyStringParsingException строка не может быть пустой
     */
    public static float convertingStringNumber(String str) throws MyStringParsingException {
        if (str == "") throw new MyStringParsingException("Строка не можбыть пустой", 0);
        else {
            float resalt = 0;
            int index = 0;
            if (str.indexOf('.') != -1 || str.indexOf(',') != -1) {
                float resalt1 = 0;
                float resalt2 = 0;
                if (str.indexOf('.') != -1) {
                    index = str.indexOf('.');
                } else {
                    index = str.indexOf(',');
                }
                int count = 0;
                for (int i = index - 1; i >= 0; i--) {
                    resalt1 += parserElement(String.valueOf(str.charAt(i)), i) * pow(10, count);
                    count++;
                }
                count = str.length() - index - 2;
                for (int j = index + 1; j < str.length(); j++) {
                    resalt2 += parserElement(String.valueOf(str.charAt(j)), j) * pow(10, count);
                    count--;
                }
                resalt = resalt1 + resalt2 / pow(10, str.length() - index - 1);
            } else {
                for (int k = str.length() - 1; k >= 0; k--) {
                    resalt += parserElement(String.valueOf(str.charAt(k)), k) * pow(10, index);
                    index++;
                }
            }
            return resalt;
        }
    }

    /**
     * Вспомогательный метод, преобразование значения элемента к числу
     *
     * @param element значение элимента строки
     * @param index   индекс элимента строки
     * @return
     * @throws MyStringParsingException Некоректный фомат данны
     */
    static int parserElement(String element, int index) throws MyStringParsingException {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new MyStringParsingException(String.format("Некоректный фомат данных %s под индексом %d", element, index), index);
        }
    }

    /**
     * Метод возведения в степень
     *
     * @param value    число
     * @param powValue степень
     * @return
     */
    public static int pow(int value, int powValue) {
        if (powValue == 1) return value;
        else if (powValue == 0) return 1;
        else return value * pow(value, powValue - 1);
    }

    //Тест проверки работы
    public static void test() {
        String[] strArray = {"123.0", "123", "12,34", " jg12", "12a", " 12,34"};
        for (int i = 0; i < strArray.length; i++) {
            try {

                System.out.println("Введено число: " + strArray[i]);
                System.out.println("Было введено число: " + convertingStringNumber(strArray[i]));

            } catch (MyStringParsingException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

abstract class MyException extends Exception {
    private final int index;

    public MyException(String message, int index) {
        super(message);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

class MyStringParsingException extends MyException {
    public MyStringParsingException(String message, int index) {
        super(message, index);
    }
}
