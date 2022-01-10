package bytedance.school;

public class Main4 {

    public static void main(String[] args) {
        int[] array = new int[]{10, 3, 5, 7};

        int max = 0;
        int tempMax = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                tempMax++;
            } else {
                if (max < tempMax) {
                    max = tempMax;
                }
                tempMax = 0;
            }

            if (i == array.length - 2) {
                if (max < tempMax) {
                    max = tempMax;
                }
            }
        }

        System.out.println(max);
    }
}
