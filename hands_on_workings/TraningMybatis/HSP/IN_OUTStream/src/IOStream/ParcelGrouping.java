package IOStream;

import java.util.HashMap;

public class ParcelGrouping {
    private static final int MOD = 1000000007;

    public static int numberOfWaysToGroupParcels(int[] weights, int wt) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int weight : weights) {
            frequencyMap.put(weight, frequencyMap.getOrDefault(weight, 0) + 1);
        }

        long count = 0;
        for (int weight : frequencyMap.keySet()) {
            int partnerWeight = weight + wt;
            if (frequencyMap.containsKey(partnerWeight)) {
                long pairs = Math.min(frequencyMap.get(weight), frequencyMap.get(partnerWeight));
                count = (count + pairs) % MOD;
            }
        }

        return (int) count;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5}; // 示例包裹重量
        int wt = 1; // 误差重量
        System.out.println(numberOfWaysToGroupParcels(weights, wt)); // 打印分组方式数
    }
}

/*
[4, 5, 5, 4, 4, 5, 2, 3]
1,2;3,4;5,6;
1,2;3,5;4,6;
1,3;2,4;5,6;
1,3;2,5;4,6;
1,6;2,4;3,5;
1,6;2,5;3,4;

 */
