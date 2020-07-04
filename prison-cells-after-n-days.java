/** 
* Prison Cells After N Days
* https://leetcode.com/problems/prison-cells-after-n-days/
*/
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        List<String> set = new LinkedList<>();
        int cycles = 0;
        
        for (int i = 0; i < N; i++) {
            int[] tmp = calculateCells(cells);
            String mapping = Arrays.toString(tmp);
            
            if (set.contains(mapping)) {
                break;
            }
            else {
                set.add(mapping);
                cycles++;
            }
            
            cells = tmp;
        }
        
        int remainingDays = N % cycles;
        
        for (int i = 0; i < remainingDays; i++) {
            cells = calculateCells(cells);
        }
        
        return cells;
    }
    
    private int[] calculateCells(int[] cells) {
        int[] tmp = new int[cells.length];
        
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                tmp[i] = 1;
            }
        }
        
        return tmp;
    }
}
