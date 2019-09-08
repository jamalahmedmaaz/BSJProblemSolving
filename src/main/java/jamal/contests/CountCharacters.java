package jamal.contests;

class CountCharacters {
    public static void main(String[] args) {
        CountCharacters countCharacters = new CountCharacters();
        System.out.println(countCharacters.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, ""));
        System.out.println(countCharacters.countCharacters(new String[]{}, ""));
    }

    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];

        for (char c : chars.toCharArray()) {
            int index = c - 'a';
            counts[index]++;
        }
        int count = 0;
        for (String word : words) {
            int[] tmp = counts.clone();
            int tmpcount = 0;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (--tmp[index] >= 0) {
                    tmpcount++;
                }
            }
            if (word.length() == tmpcount) {
                count = count + tmpcount;
            }
        }
        return count;
    }
}