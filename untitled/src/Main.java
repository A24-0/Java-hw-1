import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1
        System.out.print("1.Введите год:");
        int year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Leap");
        }
        else { System.out.println("No Leap"); }

        //2
        System.out.print("2.Введите целое положительное число (не более  2^31): ");
        int number = scanner.nextInt();

        // Перестановка старших двух байт и младших двух байт
        int swappedNumber = ((number & 0x0000FFFF) << 16) | ((number & 0xFFFF0000) >>> 16);

        System.out.println("Перевернутое число: " + swappedNumber);

        //3
        System.out.print("Введите натуральное число: ");
        int number_ = scanner.nextInt();

        int iterations = countIterations(number_);
        System.out.println("Количество итераций: " + iterations);

        //4
        // Считываем размер массива
        System.out.print("Введите количество элементов в массиве: ");
        int N = scanner.nextInt();

        // Создаем массив
        int[] arr = new int[N];

        // Считываем элементы массива
        System.out.println("Введите элементы массива (0 или 1):");
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Подсчитываем количество единиц и нулей
        int countZeros = 0;
        int countOnes = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                countZeros++;
            } else if (arr[i] == 1) {
                countOnes++;
            }
        }

        // Выводим результаты
        System.out.println("Количество нулей: " + countZeros);
        System.out.println("Количество единиц: " + countOnes);

        //5
        int[] array = {4, 2, 5, 3, 1}; // Пример входного массива
        rearrangeArray(array);

        // Выводим результат
        System.out.println("Отсортированный массив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    //3
    public static int countIterations(int number) {
        int iterations = 0;
        while (number != 1) {
            if (number % 2 == 0)
                number /= 2;
            else
                number = 3 * number + 1;
            iterations++;
        }
        return iterations;
    }

    //5
    public static void rearrangeArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            while (array[i] != i + 1) {
                int temp = array[i];
                array[i] = array[temp - 1];
                array[temp - 1] = temp;
            }
        }
    }
}