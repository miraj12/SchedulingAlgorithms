import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class SJF {

	public static void runSJF(ArrayList<Job> job) {
		
		ArrayList<Job> jobList = new ArrayList<Job>(job);
		int numJobs = jobList.size();
		
		ArrayList<Job> ganttChart = new ArrayList<Job>();
		
		Job[] jobListA = jobList.toArray(new Job[jobList.size()]);
		Comparator<Job> c = new Comparator<Job>() {

			public int compare(Job j1, Job j2) {
				return (j1.getBurstTime() - j2.getBurstTime());
			}
			
		};
		Arrays.sort(jobListA, c);
		
		int avgWaitingTime = 0;
		int avgTurnaroundTime = 0;
		int time = 0;
		
		for(int i = 0; i < jobListA.length; i ++) {
			Job j = jobListA[i];
			ganttChart.add(j);
			time += j.getBurstTime();
			if(i < jobListA.length - 1) {
				avgWaitingTime += time;
			}
			avgTurnaroundTime += time;
		}
		
		System.out.println("Shortest Job First :");
		System.out.println("Average waiting time: " + avgWaitingTime + " / " + 
				numJobs + " = " + ((1.0 * avgWaitingTime) / numJobs));
		
		System.out.println("Average Turnaround time: "  + ((1.0 * avgTurnaroundTime) / numJobs));
		
		GanttChart.printChart(ganttChart);
		
	}
}
