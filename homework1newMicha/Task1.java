package homework1newMicha;
//Напишите метод, который удаляет все дубликаты из отсортированного массива.
// Метод должен вернуть длину нового массива без дубликатов и изменить исходный массив
// таким образом, чтобы все уникальные элементы были перемещены в начало.
//
//        Пример:
//Ввод: nums = {2, 2, 3, 3, 3, 4, 5, 5}
//Вывод: Длина нового массива: 4, измененный массив: {2, 3, 4, 5, _, _, _, _}


import java.util.Arrays;
import java.util.Objects;

public class Task1 {

        public static void main(String[] args) {
            Integer[] nums = {2, 2, 3, 3, 3, 4, 5, 5};
            Integer[] nums1 = {2, 3, 4, 5, 6, 7, 8, 9};
            Integer[] nums2 = {2, 2, 2, 2, 2, 2, 2, 2};


            System.out.println(Arrays.toString(nums1));
            System.out.println("the size of unique numbers is " + getUniqueArrSize(nums1));
            System.out.println(Arrays.toString(nums1));
            System.out.println("-------");
            System.out.println(Arrays.toString(nums));
            System.out.println("the size of unique numbers is " + getUniqueArrSize(nums));;
            System.out.println(Arrays.toString(nums));
            System.out.println("-------");
            System.out.println(Arrays.toString(nums2));
            System.out.println("the size of unique numbers is " + getUniqueArrSize(nums2));
            System.out.println(Arrays.toString(nums2));
        }

        private static int getUniqueArrSize(Integer[] nums) {
            int first = 0;
            int next = 1;

            while (next < nums.length) {
                if (Objects.equals(nums[first], nums[next])) {
                    nums[next++] = null;
                } else {
                    first++;
                    if (first != next) {
                        nums[first] = nums[next];
                        nums[next] = null;
                    }
                    next++;
                }
            }
            return first + 1;
        }
    }

