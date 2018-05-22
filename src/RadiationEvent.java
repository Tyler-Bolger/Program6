
public class RadiationEvent {
	
	private String eventDate;
	private String eventTime;
	private String frequency;
	private int counts;
	
	
	public RadiationEvent() {
		this.eventDate = "";
		this.eventTime = "";
		this.frequency = "";
		this.counts = 0;
	}
	
	public RadiationEvent(String date, String time, String freq, String count) {
		this.eventDate = date;
		this.eventTime = time;
		this.frequency = freq;
		this.counts = Integer.parseInt(count);
	}
	
	public void setEventDate(String date) {
		this.eventDate = date;
	}
	
	public void setEventTime(String time) {
		this.eventTime = time;
	}
	
	public void setFrequency(String freq) {
		this.frequency = freq;
	}
	
	public void setCounts(String count) {
		this.counts = Integer.parseInt(count);
	}
	
	public String getEventDate() {
		return this.eventDate;
	}
	
	public String getEventTime() {
		return this.eventTime;
	}
	
	public String getFrequency() {
		return this.frequency;
	}
	
	public int getCounts() {
		return this.counts;
	}
}
