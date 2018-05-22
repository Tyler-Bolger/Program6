import java.util.*;
import java.io.*;

public class Program6 {

	public static void main(String[] args) {	
		
		String fileName = go();
		
		ArrayList<RadiationEvent> radEvents = new ArrayList<RadiationEvent>();
		
		radEvents = makeRadEvents(fileName);
		
		printSelections(radEvents);
		

	}
	
	public static ArrayList<RadiationEvent> makeRadEvents(String fileName) {
		ArrayList<RadiationEvent> newRad= new ArrayList<RadiationEvent>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			
			String line = "";
			
			while((line = br.readLine()) != null){

				String nstr1 = line.substring(0, 10);
				String nstr2 = line.substring(11, 16);
				String nstr3 = line.substring(17, 29);
				String nstr4 = line.substring(30).replaceAll("\\D", "");
				
				RadiationEvent radEvent = new RadiationEvent(nstr1, nstr2, nstr3, nstr4);
				
				newRad.add(radEvent);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newRad;
	}
	
	public static void printByHighestCounts(ArrayList<RadiationEvent> radEvents) {
		
		radEvents.sort(Comparator.comparing(RadiationEvent::getCounts).reversed());

		int highCount = radEvents.get(0).getCounts();
		
		
		for(RadiationEvent r : radEvents) {
			if(r.getCounts() >= (highCount - 5)) {
				System.out.println(r.getCounts() +" "+ r.getEventDate());
			}else {
				break;
			}
		}
	}
	
    public static void fancyPrint(ArrayList<RadiationEvent> readingsList) {
    	
        int count = 0;
        String printOut;
        for (RadiationEvent radEvent : readingsList) {
            if (count % 10 == 0) {
                printOut = radEvent.getEventDate()+ " " + radEvent.getEventTime() + " | ";
            } else {
                printOut = "                 | ";
            }
            for (int i = 0; i < radEvent.getCounts(); i++) {
              printOut += "*";
            }
            System.out.println(printOut);
            count++;
        }
    }
	
	public static String go() {
		
		System.out.print("Please enter the name of the file containing radiation events: ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.next();
		
		return fileName;
	}
	
	public static void printSelections(ArrayList<RadiationEvent> radEvents) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			
			System.out.print("Press 1 to print a histogram, press 2 to print by highest count: ");
			int selection = Integer.parseInt(br.readLine());
			
			if(selection == 1) {
				fancyPrint(radEvents);
			} else if (selection == 2) {
				printByHighestCounts(radEvents);
			} else {
				System.out.println("That's not a choice, lets try that again.");
				printSelections(radEvents);
			}
		} catch (IOException e) {
			System.out.println("Something went wrong, lets try that again.");
			printSelections(radEvents);
		} 
	}
}
