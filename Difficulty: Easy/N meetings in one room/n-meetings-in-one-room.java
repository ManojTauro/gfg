class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        List<Meeting> meetings = new ArrayList<>();

       for (int i = 0; i < end.length; i++) {
            Meeting m = new Meeting(start[i], end[i], i);
            meetings.add(m);
       }

       meetings.sort(Comparator.comparingInt(m -> m.end));

       int prevEnd = -1;
       int count = 0;

       for (Meeting m: meetings) {
        if (m.start > prevEnd) {
            count++;
            prevEnd = m.end;
        }
       }

       return count;
    }
}

class Meeting {
    int start;
    int end;
    int pos;
    
    public Meeting(int s, int e, int p) {
        start = s;
        end = e;
        pos = p;
    }
}