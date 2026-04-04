class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        int[][] cars = new int[length][2];
        float maxTime = 0;
        int fleets = 0;

        for(int i = 0; i < length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> a[0] - b[0]);

        for(int i = length - 1; i >= 0; i--){
            float time = (float) (target - cars[i][0]) / cars[i][1];
            if(time > maxTime){
                maxTime = time;
                fleets++;
            }
        }

        return fleets;
    }
}
