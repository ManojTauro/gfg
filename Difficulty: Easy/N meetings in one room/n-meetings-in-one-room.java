class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        List<Pair> meetings = new ArrayList<>();
        int len = start.length;
        
        for (int i = 0; i < len; i++) {
            Pair p = new Pair(start[i], end[i]);
            meetings.add(p);
        }
        
        // sort meetings based on meeting end time
        Comparator<Pair> cmp = (
            (m1, m2) -> Integer.compare(m1.end, m2.end)
        );
        Collections.sort(meetings, cmp);
        
        Pair firstMeeting = meetings.get(0);
        int lastMeetingEndTime = firstMeeting.end;
        int ans = 1;
        
        for (int i = 1; i < len; i++) {
            Pair meeting = meetings.get(i);
            
            if (meeting.start > lastMeetingEndTime) {
                ans++;
                lastMeetingEndTime = meeting.end;
            }
        }
        
        return ans;
    }
    
    record Pair(int start, int end) {}
}
