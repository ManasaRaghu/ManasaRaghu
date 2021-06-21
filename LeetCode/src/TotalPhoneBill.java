/**
 * 
 * Codility test. This question, or some variant thereof, is one of the stock questions in the Codility test suite.
 * 
 *  Given a phone calls log in the form of a string with each record separated by \n (ascii code 10) calculate the total phone bill.
 *  Each record is correctly formed as "HH:MM:SS,nnn-nnn-nnn" e.g. "00:01:07,400-234-090" refers to a phone call to phone number 
 *  400-234-090 and lasted a duration of 1 minute and 7 seconds.
 *  Rules for calculating charges:
 *		   (i) For a phone call less than 5 minutes long charge 3 cents per second
 *		   (ii) For a phone call 5 minutes and longer charge 150 cents per started minute, so for a call of 5 minutes 2 seconds would be
 *		        charged as a 6 minute call i.e. 6 * 150 = 900 cents
 *		   (iii) All calls to the phone number with the longest total call duration are free. In the event that two phone numbers have the same total call duration use the one
 * 
 * @author Manasa Raghu (2020)
 *
 */


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
	
public class TotalPhoneBill {
	
	    public static int Solution(String S) {
	        String[] firstSpilt = S.split("\\n");
	        int costOfCall = 0;
	        Map<String, Duration> phoneAndCallDetails = new HashMap<>();
	        
	        for(String callDeatils : firstSpilt) {
	        	String[] secondSpilt = callDeatils.split(",");
	        	
	        	String[] durationSplit = secondSpilt[0].split(":");
	        	
	        	Duration duration = Duration.ofHours(Integer.valueOf(durationSplit[0]))
	        			.plusMinutes(Integer.valueOf(durationSplit[1]))
	        			.plusSeconds(Integer.valueOf(durationSplit[2]));
	        	
	        	
	        	if(phoneAndCallDetails.get(secondSpilt[1]) != null) {
	        		Duration addingDuration = duration.plus(phoneAndCallDetails.get(secondSpilt[1])); 
	        		phoneAndCallDetails.replace(secondSpilt[1], addingDuration);
	        		
	        	}else {
	        		
	        		phoneAndCallDetails.put(secondSpilt[1], duration);
	        	}
	        }
	        
	        List<Integer> allDuration = new ArrayList<>();
	       
	        Iterator<Map.Entry<String,Duration>> iter = phoneAndCallDetails.entrySet().iterator();
	        
	        while (iter.hasNext()) {
	            Map.Entry<String,Duration> entry = iter.next();
	            allDuration.add((int) entry.getValue().getSeconds());
	        }
	        
	        Integer highestDuration = Collections.max(allDuration);
	        
	        List<Integer> tiedNUmbers = new ArrayList<>();
	        
	        iter = phoneAndCallDetails.entrySet().iterator();
	        while (iter.hasNext()) {
	            Map.Entry<String,Duration> entry = iter.next();
	            if(entry.getValue().getSeconds() == highestDuration) {
	            	tiedNUmbers.add(Integer.valueOf(entry.getKey().replaceAll("-", "")));
	            }
	            
	        }
	        
	        Integer minPhoneNumber = Collections.min(tiedNUmbers);
	        
/*another way to right above two loops
 * 
 */
	        
//	        Integer maxDuration = 0;
//	        String minPhoneNumber = null;
//	        Integer maxPhoneNumber = 0;
//	        Iterator<Map.Entry<String,Duration>> iter = phoneAndCallDetails.entrySet().iterator();
//	        while (iter.hasNext()) {
//	            Map.Entry<String,Duration> entry = iter.next();
//	            Integer duration = (int) entry.getValue().getSeconds();
//	            if(duration > maxDuration) {
//	            	maxDuration =  duration;
//	            	maxPhoneNumber = Integer.valueOf(entry.getKey().replace("-", ""));
//	            	minPhoneNumber = entry.getKey().replace("-", "");
//	            }else {
//	            	if(duration == maxDuration) {
//	            		if(Integer.valueOf(entry.getKey().replace("-", "")) < maxPhoneNumber) {
//	            			maxPhoneNumber = Integer.valueOf(entry.getKey().replace("-", ""));
//	            			minPhoneNumber = entry.getKey().replace("-", "");
//	            		}
//	            		
//	            	}
//	            }
//	            
//	        }
	        
	        iter = phoneAndCallDetails.entrySet().iterator();
	        while (iter.hasNext()) {
	            Map.Entry<String,Duration> entry = iter.next();
	            if (entry.getKey().replaceAll("-", "").equals(minPhoneNumber.toString())) continue;
	            
	           if(entry.getValue().getSeconds() > 300) {
	            	costOfCall += ((entry.getValue().getSeconds()/60) * 150);
					if (entry.getValue().getSeconds() % 60 != 0) costOfCall += 150;
	            }else {
	            	costOfCall += entry.getValue().getSeconds() * 3;
	            }
		           
	            
	        }
	    	
	    	return costOfCall;
	    }

	public static void main(String[] args) {
		String phoneLog = "00:01:07,700-080-080"+ "\n" +
				  "00:05:01,701-080-080" + "\n" +
				  "00:05:00,700-080-080" 
				  +"\n" +
				  "00:01:06,701-080-080" + "\n" +
				  "00:02:30, 123-456-789"
				  ;
		
		Integer totalCost = Solution(phoneLog);
		
		System.out.println(totalCost);
	}

}
