package Igorr;

class Sort {
    public static int count = 0;
    /**
     * меняет местами значения в массиве по индексам
     *
     * @param arr исходный массив
     * @param l   индекс для первого значения
     * @param r   индекс для второго значения
     * @return ссылка на выходной массив
     */
    private static Integer[] exchange(Integer[] arr, int l, int r) {
        if (l != r) {
            arr[l] += arr[r];
            arr[r] -= arr[l];
            arr[l] += arr[r];
            arr[r] *= -1;
        }
        return arr;
    }


    public static Integer[] sorting(int start, int end, Integer... arr) {
        count++;
        //если значение одно и сортировать уже нечего.
        //то есть правый указатель указывает на начало массива
        if (end <= start) return arr;

        int pivot = arr[start], left = start + 1, right = end;

        while (true) {
            //ищем значения меньше и больше контрольной точки, проверяя границы массива
            while (arr[left] <= pivot && left < arr.length - 1) left++;
            while (arr[right] > pivot && right > 0) right--;

            //если указатели сошлись
            if (left >= right) break;
            //поменять местами если размер левого не превысил размер правого,
            //иначе поменять местами опорный(он же первый) с правым
            if (left < right) {
                arr = exchange(arr, left, right);
            }
        }
        //поставить на точно свое место контрольный символ
        arr = exchange(arr, start, right);

        //сортировать части слева и справа от right
        arr = sorting(0, right - 1, arr);
        arr = sorting(right + 1, end, arr);

        return arr;
    }
}

public class Main {

    public static void main(String[] args) {
        //Integer[] arr = {1, 53, 4, 3, 41, 56, 45, 68, 15, 46, 64, 5, 6, 8, 51, 33, 54};
        //Integer[] arr = {4, 1, -2, 6, 5, -1, 1, 7, 8, 6, 5, -1, 9, 7, -1, 0, 0, 0, 0, 0, 5, 5, -5, 5};
        Integer[] arr = {6, 5};
        //Integer[] arr = {1,2,3,4,5};
        arr = Sort.sorting(0, arr.length - 1, arr);
        System.out.println(Sort.count);
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
    }
}