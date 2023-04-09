import java.util.Random;

/**
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 * и возвращающий новый массив, каждый элемент которого равен разности элементов
 * двух входящих массивов в той же ячейке. Если длины массивов не равны,
 * необходимо как-то оповестить пользователя.
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 * и возвращающий новый массив, каждый элемент которого равен частному элементов двух
 * входящих массивов в той же ячейке. Если длины массивов не равны,
 * необходимо как-то оповестить пользователя.
 * Важно: При выполнении метода единственное исключение,
 * которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */


public class Lesson01 {
    static Random random = new Random();
    public static void main(String[] args) {
        //test1();  //Массивы равны по длине, значения масивов не равны 0
        //test2();  //длина масивов равна 0
        //test3();  //один из масивов равен null
        //test4();  //Количество элиментов в масиве не равно
        test5(); //элимент второго массива делитель равен 0
    }

    //Метод вывода массива в консоль
    public static void printArray(int[] array){
        for(Number number : array){
            System.out.print(number + " ");
        }
        System.out.println();
    }

    //Метот операций с масивами
    public static int[] operationArray(int[] array1, int[] array2, int option){
        if (array1 == null || array1 == null) {
            throw new NullPointerException("Оба массива должны существовать.");
        }else if(array1.length != array2.length){
            throw new ExaminationArraySize("Количество элиментов в массивах не равны", array1.length, array2.length);
        }else if(array1.length == 0){
            throw new RuntimeException("Количество элиментов в массивах равно 0");
        }
        int[] result = new int[array1.length];
        for(int i = 0; i < array1.length; i++){
            if(array2[i] == 0){
                throw new RuntimeException(String.format("Некорректное значение элемента массива Array2 по индексу [%d]", i));
            }
            if(option == 0){
               result[i] = array1[i] / array2[i];
            }else if(option == 1){
                result[i] = array1[i] * array2[i];;
            }else if(option == 2){
                result[i] = array1[i] - array2[i];;
            }else if(option == 3){
                result[i] = array1[i] + array2[i];;
            }
        }
        return result;
    }

    //Метот заполнения массива
    public static int[] fillArray(int size){
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(20)+1;
        }
        return array;
    }

    //Тест работы программы
    public static void testArray(int[] array1, int[] array2, int option){
        try {
            int[] res = operationArray(array1, array2, option);
            String[] strArr = {"частное", "произведение", "разность", "сумма"};
            System.out.printf("%s Array ", strArr[option]);
            printArray(res);
        }
        catch (ExaminationArraySize e){
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        }
    }
    public static void test1(){
        int size = random.nextInt(10);
        int[] array1 = fillArray(size);
        int[] array2 = fillArray(size);
        printArray(array1);
        printArray(array2);
        for(int i = 0; i < 4; i++){
            testArray(array1, array2, i);
        }
    }

    public static void test2(){
        int[] array1 = fillArray(0);
        int[] array2 = fillArray(0);
        testArray(array1, array2, 0);
    }

    public static void test3(){
        int[] array1 = null;
        int[] array2 = fillArray(0);
        testArray(array1, array2, 0);
    }

    public static void test4(){
        int[] array1 = fillArray(5);
        int[] array2 = fillArray(3);
        testArray(array1, array2, 0);
    }

    public static void test5(){
        int[] array1 = fillArray(3);
        int[] array2 = {0, 5, 6};
        testArray(array1, array2, 0);
    }
}

//Проверка исключения
class ExaminationArraySize extends RuntimeException {

    private int length1;
    private int length2;

    public int getLength1() {
        return length1;
    }

    public int getLength2() {
        return length2;
    }

    public ExaminationArraySize(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }
}
