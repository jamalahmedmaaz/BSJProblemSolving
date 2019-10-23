import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CourseSchedule {
    Map<Integer, Set<Integer>> graph = new HashMap();
    Set<Integer> visited = new HashSet();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            int parent = pre[1];
            int child = pre[0];
            if (!graph.containsKey(child)) {
                graph.put(child, new HashSet());
            }
            graph.get(child).add(parent);
            if (!graph.containsKey(parent)) {
                graph.put(parent, new HashSet());
            }
            graph.get(parent).add(child);
        }
        System.out.println(graph);

        return isCyclic(numCourses);
    }

    private boolean isCyclic(int numCourses) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack) {
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        recStack[i] = true;
        Set<Integer> children = graph.get(i);
        for (Integer c : children) {
            if (isCyclicUtil(c, visited, recStack)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }

}