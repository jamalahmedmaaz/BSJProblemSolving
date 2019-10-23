package jamal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
public class LogSystem {

    TreeMap<Long, Integer> treeMap = new TreeMap();
    DateFormat dateFormat = new SimpleDateFormat("yyyy:mm:dd:hh:mm:ss");

    public LogSystem() {
    }

    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem();
    }

    public void put(int id, String timestamp) throws Exception {
        long l = dateFormat.parse(timestamp).getTime();
        treeMap.put(l, id);
    }

    public List<Integer> retrieve(String s, String e, String gra) throws Exception {
        long startEpoc = dateFormat.parse(s).getTime();
        long endEpoc = dateFormat.parse(e).getTime();
        NavigableMap<Long, Integer> navi = treeMap.subMap(
                startEpoc,
                true,
                endEpoc,
                true);

        return new ArrayList(navi.values());
    }
}