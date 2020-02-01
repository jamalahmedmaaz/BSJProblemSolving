//In this task you have to create all permutations of an input string and remove duplicates,
//if present. This means, you have to shuffle all letters from the input in all possible orders.
//Examples: permutations('a');
// ['a'] permutations('ab');
// ['ab', 'ba'] permutations('aabb'); // ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa'] The order of the permutations doesn't matter.

O(n!)

        3! = 3*2 = 6

        ABC->ABC,ACB,BCA.....

        A B C
        0 1 2

        Permutation-I

        0 1 2 3
        "A B C D"
        Permutation-II(with duplicate)

        ""
        used=[A]A

        [A,B]B

        [A,B,C]C D

        [A,B,C,D]D C

class Solution1 {

    List<Character> tmp = ArrayList();
    List<String> result = new ArrayList();
    char[] A;
    boolean[] used;

    public List<String> permutation(String text) {
        used = new boolean[text.length()];
        A = text.toCharArray();
        Arrays.sort(A);
        permuatation();
        return result;
    }

    public void permuatation(String permute) {
        if (permute.length() == A.length) {
            result.add(permute);
        } else {
            for (int i = 0; i < text.length(); i++) {
                char c = A[i];
                if (used[i]) {
                    continue;
                }
                if (i > 0 && A[i] == A[i - 1] && !used[i - 1]) {
                    continue;
                }

                permute += c;
                used[i] = true;

                permutation();

                permute = permute.substring(0,permute.length());
                tmp.remove(tmp.size() - 1);

                used[i] = false;

            }
        }

    }

    public boolean isValidParanthesis(String paranthesis) {
        return false;
    }

    public int addMinTwoElements(int[] A) {
        //1. Solution1 : Sort array. and then add index 0 and index 1; (O(nlog(n))
        //2. Convert by A: PriorityQueue (pop two times, and add them). (O (n.log(2))

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int ele : A) {
            if (first > ele) {
                second = first;
                first = ele;
            } else if (second > ele) {
                second = ele;
            }
        }
        return first + second;
    }

    public int[] invert(int[] A) {
        //Base condition.
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
        return A;
    }

    public int populationCalculator(int intitalPopulation, int perc, int newAddition, int targetPopulation) {
        int countOfYears = 0;
        int tmpPopulation = intitalPopulation;

        while (tmpPopulation < targetPopulation) {
            countOfYears;
            tmpPopulation = tmpPopulation + (tmpPopulation * perc) + newAddition;
        }
        return countOfYears;
    }

}