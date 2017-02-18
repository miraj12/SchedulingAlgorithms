import java.util.ArrayList;


public class FCFS {
	
	public static void runFCFS(ArrayList<Job> job) {
		
		ArrayList<Job> jobList = new ArrayList<Job>(job);
		ArrayList<Job> ganttPrint = new ArrayList<Job>();
		int numJobs = jobList.size();
		
		int avgWaitingTime = 0;
		int avgTurnAroundTime = 0;
		int time = 0;
	
		while(! jobList.isEmpty()) {
			Job j = jobList.remove(0);
			ganttPrint.add(j);
			
			if(!jobList.isEmpty()) {
				avgWaitingTime += time + j.getBurstTime();
			}
			
			avgTurnAroundTime += time + j.getBurstTime();
			time += j.getBurstTime();
			
			//System.out.print(" - " + j.getJobId() + " - " + time);
			
		}
		
		System.out.println("First Come First Serve :");
		System.out.println("Average waiting time: " + avgWaitingTime + " / " + 
				numJobs + " = " + ((1.0 * avgWaitingTime) / numJobs));
		
		System.out.println("Average Turnaround time: "  + ((1.0 * avgTurnAroundTime) / numJobs));
		
		GanttChart.printChart(ganttPrint);
	}

}
