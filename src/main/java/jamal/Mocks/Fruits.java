package jamal.Mocks;

import java.util.LinkedHashMap;
import java.util.Map;
public class Fruits {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalFruit(new int[]{748, 166, 166, 386, 386, 166, 881, 994, 881, 131, 78, 131, 78, 509, 78, 509, 865, 865, 509, 865, 509, 582, 509, 582, 207, 559, 559, 559, 559, 378, 324, 378, 378, 324, 378, 448, 378, 797, 797, 18, 797, 692, 797, 379, 379, 880, 761, 538, 538, 310, 389, 310, 389, 328, 855, 855, 855, 855, 693, 855, 468, 855, 468, 468, 468, 461, 468, 461, 461, 461, 510, 461, 1, 461, 461, 461, 371, 155, 56, 23, 580, 23, 580, 580, 89, 314, 298, 555, 543, 543, 555, 543, 543, 555, 543, 543, 543, 90, 543, 90, 706, 407, 707, 761, 638, 489, 497, 904, 497, 497, 849, 497, 849, 880, 849, 575, 808, 342, 342, 342, 342, 26, 312, 312, 384, 589, 234, 447, 447, 683, 564, 430, 430, 564, 808, 808, 314, 808, 314, 314, 799, 314, 83, 83, 83, 83, 336, 336, 83, 539, 539, 527, 539, 539, 539, 398, 398, 398, 539, 398, 398, 100, 893, 799, 913, 400, 913, 400, 817, 452, 309, 309, 309, 618, 445, 445, 618, 63, 618, 2, 2, 618, 2, 738, 625, 732, 768, 711, 768, 768, 873, 247, 247, 873, 873, 247, 873, 873, 424, 424, 873, 538, 212, 212, 538, 91, 538, 723, 276, 276, 723, 723, 554, 373, 373, 443, 471, 53, 532, 532, 643, 192, 192, 643, 192, 898, 942, 942, 941, 340, 340, 941, 941, 340, 340, 767, 382, 382, 683, 382, 382, 382, 382, 683, 382, 382, 382, 683, 591, 902, 902, 808, 808, 902, 350, 350, 581, 532, 537, 532, 654, 162, 42, 42, 162, 291, 291, 457, 291, 291, 457, 94, 94, 550, 94, 94, 94, 560, 94, 314, 94, 550, 94, 94, 550, 550, 475, 475, 475, 475, 394, 447, 394, 123, 123, 634, 221, 69, 69, 176, 69, 677, 106, 677, 677, 677, 868, 442, 958, 442, 958, 400, 120, 403, 403, 403, 120, 403, 120, 403, 403, 403, 419, 403, 419, 246, 419, 246, 419, 246, 107, 6, 107, 6, 6, 6, 614, 149, 505, 817, 505, 584, 584, 605, 605, 584, 584, 448, 310, 448, 751, 694, 0, 540, 0, 540, 540, 540, 0, 540, 392, 590, 392, 392, 590, 590, 392, 338, 392, 580, 901, 901, 901, 599, 599, 901, 599, 599, 901, 901, 265, 436, 265, 265, 436, 436, 436, 265, 539, 539, 825, 475, 825, 825, 348, 827, 348, 348, 242, 348, 494, 348, 348, 3, 722, 868, 868, 533, 834, 621, 834, 347, 834, 834, 347, 347, 575, 18, 575, 237, 279, 237, 712, 428, 712, 712, 583, 575, 250, 575, 575, 575, 258, 86, 777, 777, 777, 777, 572, 777, 572, 520, 572, 572, 335, 147, 147, 234, 61, 61, 234, 438, 199, 438, 134, 438, 134, 134, 134, 134, 134, 833, 134, 833, 134, 309, 309, 825, 825, 356, 356, 953, 953, 356, 654, 145, 632, 648, 64, 64, 498, 645, 307, 645, 645, 589, 755, 768, 755, 768, 755, 755, 49, 81, 976, 976, 81, 81, 976, 976, 81, 976, 37, 976, 982, 407, 39, 967, 730, 967, 730, 854, 854, 936, 329, 329, 902, 306, 902, 902, 318, 419, 266, 39, 369, 369, 858, 858, 858, 609, 919, 609, 919, 919, 424, 424, 919, 49, 919, 582, 140, 140, 582, 480, 349, 349, 725, 349, 725, 349, 349, 572, 936, 458, 936, 46, 257, 46, 257, 657, 920, 473, 473, 920, 473, 473, 920, 920, 920, 36, 36, 181, 141, 2, 141, 513, 141, 961, 516, 697, 516, 542, 542, 799, 542, 395, 395, 395, 468, 456, 716, 456, 943, 456, 423, 456, 423, 423, 89, 792, 553, 673, 553, 673, 673, 553, 553, 167, 167, 553, 539, 539, 310, 945, 945, 920, 920, 945, 945, 918, 515, 708, 515, 515, 383, 383, 515, 383, 130, 288, 130, 130, 810, 949, 949, 125, 949, 799, 949, 949, 799, 641, 641, 799, 641, 943, 943, 943, 824, 824, 943, 824, 943, 511, 511, 462, 799, 367, 193, 245, 427, 227, 427, 28, 427, 28, 28, 207, 595, 618, 551, 618, 551, 818, 551, 818, 818, 647, 149, 892, 943, 892, 774, 840, 840, 928, 840, 928, 420, 135, 999, 999, 839, 999, 839, 999, 430, 430, 980, 278, 278, 680, 278, 409, 61, 319, 21, 21, 21, 21, 620, 396, 620, 538, 620, 538, 253, 524, 253, 888, 253, 634, 202, 202, 202, 634, 202, 870, 114, 870, 114, 114, 258, 356, 625, 607, 607, 625, 607, 625, 20, 20, 625, 179, 625, 625, 625, 397, 625, 625, 605, 741, 538, 538, 741, 741, 276, 141, 141, 424, 141, 518, 518, 141, 331, 571, 571, 331, 902, 280, 902, 121, 256, 121, 256, 121, 121, 776, 294, 6, 294, 228, 228, 621, 850, 850, 621, 654, 654, 181, 181, 181, 30, 882, 30, 633, 30, 30, 30, 190, 305, 547, 793, 799, 799, 228, 228, 705, 990, 836, 836, 132, 132, 836, 137, 836, 289, 161, 847, 115, 773, 115, 176, 115, 855, 648, 636, 926, 123, 123, 926, 123, 417, 180, 346, 694, 134, 120, 837, 120, 634, 634, 120, 467, 120, 120, 120, 467, 120, 649, 649, 120, 120, 120, 304, 304, 325, 304, 304, 82, 304, 245, 304, 304, 245, 901, 942, 942, 901, 420, 518, 420, 722, 420, 420, 695, 420, 695, 295, 695, 372, 235, 372, 372, 235, 372, 235, 286, 286, 286, 286, 823, 286, 624, 8, 693, 502, 866, 866, 10, 215, 32, 215, 215, 484, 215, 215, 215, 23, 23, 215, 719, 182, 809, 809, 809, 809, 809, 473, 949, 473, 473, 949, 175, 949, 564, 564, 418, 693, 826, 693, 363, 957, 303, 416, 416, 303, 13, 303, 13, 646, 947, 947, 931, 947, 947, 947, 947, 931, 133, 468, 60, 527, 527, 576, 527, 554, 554, 527, 776, 776, 527, 639, 595, 999, 595, 14, 308, 308, 440, 308, 729, 360, 729, 638, 638, 212, 212, 231, 815, 324, 815, 324, 514, 514, 324, 514, 418, 514, 514, 131, 131, 101, 119, 265, 845, 71, 309, 309, 71}));
        System.out.println(solution.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(solution.totalFruit(new int[]{0, 1, 2, 2}));

    }

    static class Solution {
        public int totalFruit(int[] tree) {
            if (tree == null || tree.length == 0) {
                return 0;
            }
            if (tree.length == 1) {
                return 1;
            }
            Map<Integer, Pair> map = new LinkedHashMap();
            int max = 0;
            for (int i = 0; i < tree.length; i++) {
                int current = tree[i];

                if (map.containsKey(current)) {
                    map.get(current).setLastSeen(i);
                } else {
                    if (map.size() < 2) {
                        map.put(current, new Pair(i, i));
                    } else {
                        Map.Entry<Integer, Pair> first = map.entrySet().iterator().next();
                        map.remove(first.getKey());

                        for (Map.Entry<Integer, Pair> second : map.entrySet()) {
                            second.getValue().setFirstSeen(first.getValue().getLastSeen() + 1);
                        }

                        map.put(current, new Pair(i, i));
                    }
                }
                max = Math.max(max, calculate(map));
            }
            return max;
        }

        public int calculate(Map<Integer, Pair> map) {
            if (map.size() == 1) {
                Pair first = map.entrySet().iterator().next().getValue();
                return first.getLastSeen() - first.getFirstSeen() + 1;
            } else {

                Pair first = map.entrySet().iterator().next().getValue();
                Pair second = null;

                for (Map.Entry<Integer, Pair> inst : map.entrySet()) {
                    second = inst.getValue();
                }
                int firstLast = second.getLastSeen() - first.getFirstSeen() + 1;
                int firstLength = first.distance();
                int lastLength = second.distance();

                int max = Math.max(firstLength, lastLength);
                return Math.max(max, firstLast);
            }
        }

        private class Pair {
            int firstSeen;
            int lastSeen;

            public Pair(int firstSeen, int lastSeen) {
                this.firstSeen = firstSeen;
                this.lastSeen = lastSeen;
            }

            public int distance() {
                return lastSeen - firstSeen + 1;
            }

            public int getFirstSeen() {
                return firstSeen;
            }

            public void setFirstSeen(int firstSeen) {
                this.firstSeen = firstSeen;
            }

            public int getLastSeen() {
                return lastSeen;
            }

            public void setLastSeen(int lastSeen) {
                this.lastSeen = lastSeen;
            }
        }
    }
}
