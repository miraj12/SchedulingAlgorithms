import java.util.ArrayList;


public class GanttChart {

	public static void printChart(ArrayList<Job> jobList) {
		
		for(int i = 0; i < jobList.size(); i ++) {
			System.out.print("---------");
		}
		
		System.out.println();
		
		for(Job j : jobList) {
			System.out.print("| " + j.getJobId() + " ");
		}
		
		System.out.print("|\n");
		
		for(int i = 0; i < jobList.size(); i++) {
			System.out.print("---------");
		}
		
		System.out.print("\n" + "0");
		int time = 0;
		for(Job j : jobList) {
			time += j.getBurstTime();
			if(time < 10){
				System.out.print("        " + time );
			} else if(time < 100) {
				System.out.print("       " + time);
			} else {
				System.out.print("      " + time);
			}
		}
	}
}
