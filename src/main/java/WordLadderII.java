import java.util.*;
public class WordLadderII {

    Map<String, Set<String>> map = new HashMap();

    public static void main(String[] args) {
        int bitmask = 0;

        for (int i = 0; i < 10; i++) {
            bitmask = bitmask | 1 << i;
        }

        for (int i = 0; i < 11; i++) {
            System.out.println(bitmask & (1 << i));
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        PriorityQueue<DataElemet> pq = new PriorityQueue<>((a, b) -> a.min - b.min);
        pq.add(new DataElemet(beginWord));
        List<List<String>> result = new ArrayList();
        wordList.add(beginWord);
        wordList.add(endWord);
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                boolean add = isSimilar(word1, word2);
                if (add) {
                    if (!map.containsKey(word1)) {
                        map.put(word1, new HashSet());
                    }
                    if (!map.containsKey(word2)) {
                        map.put(word2, new HashSet());
                    }
                    map.get(word1).add(word2);
                    map.get(word2).add(word1);
                }
            }
        }

        // System.out.println(map);

        method:
        while (!pq.isEmpty()) {
            DataElemet de = pq.poll();
            String currentWord = de.word;
            int currentMin = de.min;
            if (Objects.equals(currentWord, endWord)) {
                System.out.println(" y es  ");
                if (result.isEmpty()) {
                    result.add(de.words);
                } else if (result.get(result.size() - 1).size() == de.words.size()) {
                    result.add(de.words);
                }
                continue method;
            }
            for (String edgeWord : map.getOrDefault(currentWord, new HashSet<String>())) {
                if (!de.words.contains(edgeWord)) {
                    DataElemet newDe = new DataElemet(edgeWord, currentMin + 1);
                    pq.add(newDe);
                }
            }
        }
        return result;
    }

    public boolean isSimilar(String a, String b) {
        int count = 0;

        for (int i = 0, j = 0; i < a.length(); i++, j++) {
            if (a.charAt(i) != b.charAt(j) && count < 1) {
                count++;
            } else if (a.charAt(i) != b.charAt(j) && count >= 1) {
                return false;
            }
        }
        return true;
    }

    class DataElemet {
        int min;
        String word;
        List<String> words = new ArrayList();

        public DataElemet(String word) {
            this.word = word;
            words.add(word);
        }

        public DataElemet(String word, int min) {
            this.min = min;
            this.word = word;
            words.add(word);
        }
    }
}

class Solution {
    Map<String, Set<String>> map = new HashMap();
    List<String> wordList;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList;
        Queue<DataElemet> pq = new LinkedList<>();
        pq.add(new DataElemet(beginWord));
        List<List<String>> result = new ArrayList();

        if (wordList == null || wordList.size() == 0) {
            return result;
        }
        wordList.add(beginWord);
        // wordList.add(endWord);

        map();

        // System.out.println(map);
        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            DataElemet de = pq.poll();
            String currentWord = de.word;
            int currentMin = de.min;
            if (Objects.equals(currentWord, endWord)) {
                break;
            }
            for (String edgeWord : map.getOrDefault(currentWord, new HashSet<String>())) {
                if (!de.words.contains(edgeWord)) {
                    DataElemet newDe = new DataElemet(edgeWord, currentMin + 1);
                    newDe.words.addAll(de.words);
                    newDe.words.add(edgeWord);
                    pq.add(newDe);
                    if (Objects.equals(edgeWord, endWord)) {
                        if (result.isEmpty()) {
                            min = Math.min(min, newDe.words.size());
                            result.add(new ArrayList(newDe.words));
                        } else if (result.get(result.size() - 1).size() == newDe.words.size()) {
                            result.add(new ArrayList(newDe.words));
                        }
                    }
                }
            }
        }
        return result;
    }

    public void map() {
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                boolean add = isSimilar(word1, word2);
                if (add) {
                    if (!map.containsKey(word1)) {
                        map.put(word1, new HashSet());
                    }
                    if (!map.containsKey(word2)) {
                        map.put(word2, new HashSet());
                    }
                    map.get(word1).add(word2);
                    map.get(word2).add(word1);
                }
            }
        }
    }

    public boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0, j = 0; i < a.length(); i++, j++) {
            if (a.charAt(i) != b.charAt(j) && count < 1) {
                count++;
            } else if (a.charAt(i) != b.charAt(j) && count >= 1) {
                return false;
            }
        }
        return true;
    }

    class DataElemet {
        int min;
        String word;
        Set<String> words = new LinkedHashSet();

        public DataElemet(String word) {
            this.word = word;
            words.add(word);
        }

        public DataElemet(String word, int min) {
            this.min = min;
            this.word = word;
        }
    }
}