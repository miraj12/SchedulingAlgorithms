import java.util.*;
import java.io.*;
public class Driver {

	public static void main(String[] args) {
		
		String fileName = "testdata3.txt";
		ArrayList<Job> jobs = new ArrayList<Job>();
		try {
			jobs = getJobs(fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FCFS.runFCFS(jobs);
		System.out.println("\n");
		SJF.runSJF(jobs);
		System.out.println("\n");
		RR.runRR(jobs, 2);
		System.out.println("\n");
		RR.runRR(jobs, 5);

	}
	
	public static ArrayList<Job> getJobs(String file) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader (new File(file)));
		ArrayList<Job> jobList = new ArrayList<Job>();
		
		String jobId, burstTime;
		
		while(((jobId = br.readLine()) != null) && ((burstTime = br.readLine()) != null)) {
			jobList.add(new Job (jobId, Integer.parseInt(burstTime)));
		}
		
		br.close();
		
		
		
		return jobList;
		
	}

}
