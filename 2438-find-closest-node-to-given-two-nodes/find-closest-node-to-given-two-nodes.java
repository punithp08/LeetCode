class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
      int n = edges.length;

        int[] dist1 = bfs(n, edges, node1);
        int[] dist2 = bfs(n, edges, node2);

        int minMaxDist = Integer.MAX_VALUE;
        int resultNode = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int currentMaxDist = Math.max(dist1[i], dist2[i]);

                if (currentMaxDist < minMaxDist) {
                    minMaxDist = currentMaxDist;
                    resultNode = i;
                } else if (currentMaxDist == minMaxDist) {
                    resultNode = Math.min(resultNode, i);
                }
            }
        }

        return resultNode;
    }

    private int[] bfs(int n, int[] edges, int startNode) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startNode);
        dist[startNode] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            int v = edges[u];

            if (v != -1 && dist[v] == Integer.MAX_VALUE) {
                dist[v] = dist[u] + 1;
                queue.offer(v);
            }
        }
        return dist;   
    }
}