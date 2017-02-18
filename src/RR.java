import java.util.ArrayList;


public class RR {
	
	public static void runRR(ArrayList<Job> job, int timeSlice) {
		
		ArrayList<Job> jobList = new ArrayList<Job>(job);
		ArrayList<Job> ganttChart = new ArrayList<Job>();
		int numJobs = jobList.size();
		
		double avgTurnaround = 0;
		double avgProcessingTime = 0;
		int time = 0;
		for(Job j: jobList){
			avgProcessingTime += j.getBurstTime();
		}
		while(!jobList.isEmpty()) {
			Job j = jobList.remove(0);
			int burst = j.getBurstTime();
			if(burst > timeSlice) {
				time += timeSlice;
				j.setBurstTime(burst - timeSlice);
				jobList.add(j);
				ganttChart.add(new Job(j.getJobId(),timeSlice));
				
			} else {
				time += burst;
				avgTurnaround += time;
				ganttChart.add(new Job(j.getJobId(),burst));
			}
		}
		avgTurnaround /= numJobs;
		avgProcessingTime /= numJobs;
		System.out.println("Round-Robin with time slice = " + timeSlice);
		System.out.println("Average Waiting time: " + (avgTurnaround - avgProcessingTime));
		System.out.println("Average Turnaround Time: " + avgTurnaround);
		GanttChart.printChart(ganttChart);
	}

}
