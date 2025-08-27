class Solution {
    public int maxEvents(int[][] events) {
      Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int attendedEvents = 0;
        int eventIndex = 0;
        int n = events.length;

        for (int day = 1; day <= 100000; day++) {
            while (eventIndex < n && events[eventIndex][0] == day) {
                pq.add(events[eventIndex][1]);
                eventIndex++;
            }
            
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                attendedEvents++;
            }
        }
        
        return attendedEvents;   
    }
}