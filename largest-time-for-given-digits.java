/**
* Largest Time for Given Digits
* https://leetcode.com/problems/largest-time-for-given-digits/
*/
class Solution {
    public String largestTimeFromDigits(int[] A) {
        List<Integer> list = fillList(A);
        
        for (int i = 2; i >=0; i--) {
            if (list.contains(i)) {
                String hour = constructTime(new ArrayList<Integer>(list), i, (i == 2) ? 3 : 9);

                if (!hour.isEmpty()) {
                    return hour;
                }
            }
        }
        
        return "";
    }
    
    private List<Integer> fillList(int[] A) {
        List<Integer> list = new ArrayList<>();
        
        for (int a : A) {
            list.add(a);
        }
        
        return list;
    }
    
    private String constructTime(List<Integer> list, int startLimit, int endLimit) {
        StringBuilder hour = new StringBuilder();
        
        hour.append(startLimit);
        list.remove(new Integer(startLimit));
        
        boolean found = false;
        
        for (int i = endLimit; i >= 0; i--) {
            if (list.contains(i)) { 
                hour.append(i);
                list.remove(new Integer(i));
                found = true;
                break;
            }
        }
        
        if (!found) {
            return "";
        }
        
        hour.append(":");
            
        // check for minutes and seconds
        String minutesAndSeconds = constructMinutesAndSeconds(list);

        if (minutesAndSeconds.isEmpty()) {
            return "";
        }

        return hour.toString() + minutesAndSeconds;
    }
    
    private String constructMinutesAndSeconds(List<Integer> list) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 5; i >=0; i--) {
            if (list.contains(i)) {
                result.append(i);
                list.remove(new Integer(i));
                result.append(list.get(0));
                return result.toString();
            }
        }
        
        return "";
    }
}
