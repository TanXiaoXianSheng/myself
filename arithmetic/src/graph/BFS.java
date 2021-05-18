package graph;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * BFS（Breadth First Search）
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/25 2:59 下午
 */
public class BFS {

    public static Map<Integer, Integer> fun(int[][] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        map.put(0, 0);
        for (int i = 0;i < arr[0].length;i ++) {
            if (arr[0][i] == 1 && !map.keySet().contains(i)) {
                queue.add(i);
                map.put(i, 1);
            }
        }

        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            for (int j = 0;j < arr[index].length; j ++) {
                if (arr[index][j] == 1 && !map.keySet().contains(j)) {
                    queue.add(j);
                    map.put(j, map.get(index) + 1);
                }
            }
        }

        return map;
    }



    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}
        };

        Map<Integer, Integer> map = fun(arr);
        //map.keySet().stream().forEach(x -> System.out.println(x + 1));
        map.forEach((k, v) -> System.out.println(k + 1 + ":" + v));
        int a = 1;
    }

}
