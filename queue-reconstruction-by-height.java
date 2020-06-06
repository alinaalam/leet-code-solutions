/**
* Queue Reconstruction by Height
* https://leetcode.com/problems/queue-reconstruction-by-height/
*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, this::sortPeople);
        List<int[]> queue = new LinkedList<>();
        
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        
        return queue.toArray(new int[queue.size()][]);
    }
    
    private int sortPeople(int[] person1, int[] person2) {
        if (person1[0] == person2[0]) {
            return person1[1] - person2[1];
        }
        return person2[0] - person1[0];
    }
}
