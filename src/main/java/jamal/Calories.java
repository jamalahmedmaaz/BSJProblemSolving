package jamal;

public class Calories {
    public static void main(String[] args) {
        Calories calories = new Calories();
        calories.dietPlanPerformance(new int[]{6, 13, 8, 7, 10, 1, 12, 11}, 6, 5, 37);
    }

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int total = 0;

        int tmp = 0;
        for (int i = 0; i < calories.length; i++) {

            if ((i + 1) % k == 0) {
                if (k == 1) {
                    tmp = calories[i];
                }
                if (tmp != lower) {
                    if (tmp < lower) {
                        total--;
                    }
                }
                if (tmp != upper) {
                    if (tmp > upper) {
                        total++;
                    }
                }
                tmp = 0;
            } else {
                tmp = tmp + calories[i];
            }
        }
        return total;
    }
}
