package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	Problem : Given a list of jobs where each job has a start and finish time, 
			  and also has profit associated with it, 
			  find maximum profit subset of non-overlapping jobs.

*/


class Job {
	int start, finish, profit;

	Job(int start, int finish, int profit) {
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}
	
    @Override
    public String toString(){
        return "[Start : "+start+", Finish : "+finish+", Profit : "+profit+"]";
    }
}

public class WeightedIntervalSchedule {
	
	protected int findLastNonConflictingJob(List<Job> jobs, int n) {

		for (int i = n - 1; i >= 0; i--) {
			if (jobs.get(i).finish <= jobs.get(n).start) {
				return i;
			}
		}
		return -1;
	}
	
	// Bottom-Up Approach
	protected int maxProfit(List<Job> jobs) {
		
		// sort jobs in increasing order of their finish times
		Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

		int n = jobs.size();
		int[] maxProfit = new int[n];

		maxProfit[0] = jobs.get(0).profit;

		for (int i = 1; i < n; i++) {
			int index = findLastNonConflictingJob(jobs, i);

			int incl = jobs.get(i).profit;
			if (index != -1) {
				incl += maxProfit[index];
			}
			
			maxProfit[i] = Math.max(incl, maxProfit[i - 1]);
		}

		return maxProfit[n - 1];
	}

	public static void main(String[] args) {
		
		WeightedIntervalSchedule schedule = new WeightedIntervalSchedule();
		
		List<Job> jobs = Arrays.asList(
				new Job(0, 6, 60),
				new Job(1, 4, 30),
				new Job(3, 5, 10),
				new Job(5, 7, 30),
				new Job(5, 9, 50),
				new Job(7, 8, 10)
		);

		System.out.println("For the input jobs : ");
		for(Job job : jobs)
			System.out.println(job.toString());
		System.out.println("The maximum profit is " + schedule.maxProfit(jobs));
	}

}
