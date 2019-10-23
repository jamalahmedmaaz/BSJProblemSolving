package jamal.google.onlineassesment;

public class MaximumTime {
    public static void main(String[] args) {
        MaximumTime maximumTime = new MaximumTime();
        System.out.println(maximumTime.getMaxTime("?4:5?"));
        System.out.println(maximumTime.getMaxTime("?4:??"));
        System.out.println(maximumTime.getMaxTime("?3:??"));
        System.out.println(maximumTime.getMaxTime("23:5?"));
        System.out.println(maximumTime.getMaxTime("2?:22"));
        System.out.println(maximumTime.getMaxTime("0?:??"));
        System.out.println(maximumTime.getMaxTime("1?:??"));
        System.out.println(maximumTime.getMaxTime("??:??"));
        System.out.println(maximumTime.getMaxTime("?4:0?"));
        System.out.println(maximumTime.getMaxTime("?9:4?"));
    }

    private String getMaxTime(String time) {
        char[] ta = time.toCharArray();
        for (int i = ta.length - 1; i >= 0; i--) {
            switch (i) {
                case 4:
                    ta[i] = ta[i] == '?' ? '9' : ta[i];
                    break;
                case 3:
                    ta[i] = ta[i] == '?' ? '5' : ta[i];
                    break;
                case 1:
                    if (ta[i] == '?') {
                        if (ta[i - 1] == '?') {
                            ta[i] = '3';
                            ta[i - 1] = '2';
                        } else if (Character.getNumericValue(ta[i - 1]) == 0) {
                            ta[i] = '9';
                        } else if (Character.getNumericValue(ta[i - 1]) == 1) {
                            ta[i] = '9';
                        } else if (Character.getNumericValue(ta[i - 1]) == 2) {
                            ta[i] = '3';
                        }
                    }
                    break;
                case 0:
                    if (ta[i] == '?' && Character.getNumericValue(ta[i + 1]) > 3) {
                        ta[i] = '1';
                    } else {
                        ta[i] = ta[i] == '?' ? '2' : ta[i];
                    }
                    break;
            }

        }
        return new String(ta);
    }
}
