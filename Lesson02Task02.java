/**
 * 2. Если необходимо, исправьте данный код
 * (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 * <p>
 */

public class Lesson02Task02 {

    public static void main(String[] args) {
        task02();
    }
    //Задача 2
    public static void task02(){
        int[] intArray = new int[8];;
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        catch (Exception e) {
            System.out.println("Catching exception: " + e.getMessage());
        }
    }
}


