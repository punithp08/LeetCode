class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
     Arrays.sort(players);
        Arrays.sort(trainers);

        int playerPointer = 0;
        int trainerPointer = 0;
        int matches = 0;

        while (playerPointer < players.length && trainerPointer < trainers.length) {
            if (players[playerPointer] <= trainers[trainerPointer]) {
                matches++;
                playerPointer++;
                trainerPointer++;
            } else {
                trainerPointer++;
            }
        }

        return matches;   
    }
}