import java.util.*;
import java.text.SimpleDateFormat;

public class CarRental {
	
    public static Boolean canScheduleAll(ArrayList<RentalTime> rentalTimes) {
    	
    	Comparator<RentalTime> comparator = (c1, c2) -> { 
            return Long.valueOf(c1.getEnd().getTime()).compareTo(c2.getStart().getTime()); 
    };
    	Collections.sort(rentalTimes, comparator);
    	
        for(int i = 0 ;i < rentalTimes.size()-1 ; i++){
            if((rentalTimes.get(i+1).getStart().getTime() - rentalTimes.get(i).getEnd().getTime() ) < 0) {
            	return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 20:45")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:30"), sdf.parse("03/05/2020 23:00")));
        

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class RentalTime{
    private Date start, end;
    
    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
    
}