package jamal.stack;

import java.util.*;

public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        System.out.println(3 ^ 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
        }
        System.out.println(0 ^ 0);
        ExclusiveTimeOfFunctions exclusiveTimeOfFunctions =
                new ExclusiveTimeOfFunctions();
        System.out.println(Arrays.toString(exclusiveTimeOfFunctions.exclusiveTime(2,
                Arrays.asList(new String[]{"0:start:0", "1:start:2", "1:end:5"
                        , "0:end:6"}))));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] response = new int[n];
        Stack<Integer> functionIdStack = new Stack<>();
        int previousTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            Integer functionId = Integer.parseInt(parts[0]);
            String operation = parts[1];
            Integer startOrEndTime = Integer.parseInt(parts[2]);
            if (!functionIdStack.isEmpty()) {
                int previousFunctionId = functionIdStack.peek();
                response[previousFunctionId] = response[previousFunctionId] +
                        (startOrEndTime - previousTime);
            }
            previousTime = startOrEndTime;
            switch (operation) {
                case "start":
                    functionIdStack.push(functionId);
                    break;
                case "end":
                    int tmpFunctionId = functionIdStack.pop();
                    response[tmpFunctionId]++;
                    previousTime++;
                    break;
            }
        }
        return response;
    }
}
