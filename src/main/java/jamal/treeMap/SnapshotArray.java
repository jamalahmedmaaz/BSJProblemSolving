package jamal.treeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
class SnapshotArray {

    //A map of key and Value (a map of snapshot version and value of key)
    Map<Integer, TreeMap<Integer, Integer>> map;
    int snapshot = 0;

    public SnapshotArray(int length) {
        this.map = new HashMap();
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(10);
        snapshotArray.snap();
        System.out.println(snapshotArray.get(1, 0));
        snapshotArray.set(0, 0);
        System.out.println(snapshotArray.get(1, 8));
        System.out.println(snapshotArray.get(1, 0));
    }

    public void set(int index, int val) {
        if (!map.containsKey(index)) {
            map.put(index, new TreeMap());
        }
        map.get(index).put(snapshot, val);
    }

    public int snap() {
        ++snapshot;
        return snapshot - 1;
    }

    public int get(int index, int snap_id) {
        if (map.containsKey(index)) {
            int floorKey = map.get(index).floorKey(snap_id);
            return map.get(index).get(floorKey);
        }
        return 0;
    }

    public boolean binarySearch(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else if (row[mid] < target) {
                low = mid + 1;
            }
        }
        return false;
    }
}