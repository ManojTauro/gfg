class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        
        for (int i = 0; i < deadline.length; i++) {
            jobs.add(new Job(deadline[i], profit[i]));
        }
        
        jobs.sort((j1, j2) -> Integer.compare(j2.p, j1.p));
        int maxDeadline = Arrays.stream(deadline).max().getAsInt();
        
        int[] schedule = new int[maxDeadline + 1];
        Arrays.fill(schedule, -1);
        int numJobs = 0;
        int maxProfit = 0;
        
        for (Job job: jobs) {
            int dl = job.dl;
            
            while (dl > 0 && schedule[dl] != -1) {
                dl--;
            }
            
            if (dl > 0) {
                                
            schedule[dl] = 1;
            numJobs++;
            maxProfit += job.p;
            }

        }
        
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(numJobs, maxProfit));
        return ans;
    }
}

class Job {
    int dl;
    int p;
    
    Job(int dl, int p) {
        this.dl = dl;
        this.p =p;
    }
}