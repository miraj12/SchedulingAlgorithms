
public class Job {
	private String jobId;
	private int burstTime;
	
	public Job(String jobId, int burstTime) {
		this.jobId = jobId;
		this.burstTime = burstTime;
	}

	
	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	
	

}
