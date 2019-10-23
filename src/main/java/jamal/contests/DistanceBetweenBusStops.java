package jamal.contests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DistanceBetweenBusStops {

    public static void main(String[] args) {
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0}, 0, 2));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int[][] dp = new int[distance.length][distance.length];

        for (int i = 0; i < distance.length; i++) {
            int source = i;
            int des = i + 1 >= distance.length ? 0 : i + 1;
            int weight = distance[i];

            dp[source][des] = weight;
            dp[des][source] = weight;
        }

        for (int k = 0; k < dp.length; k++) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp.length; j++) {
                    if (dp[i][j] < dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        return dp[start][destination];
    }

    public String dayOfTheWeek(int day, int month, int year) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
        Date myDate = null;
        try {
            myDate = sdf.parse(day + "/" + month + "/" + year);
        } catch (ParseException e) {
            return "";
        }
        sdf.applyPattern("EEE, d MMM yyyy");
        String sMyDate = sdf.format(myDate);
        return sMyDate;
    }

}
