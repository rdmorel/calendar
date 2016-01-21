public class CalendarEvent implements Comparable<CalendarEvent> {

	DSDate date = new DSDate();
	Time time = new Time();
	public String description = "";
	
	public void setDate(int m, int d, int y){
		this.date.setMonth(m);
		this.date.setDay(d);
		this.date.setYear(y);
	}
	public void setTime(int h, int m){ //Note: I am assuming hour should be from 1-24, not 1-12
		this.time.setHour(h);
		this.time.setMinute(m);
	}
	public void setDescription(String desc){
		description = desc;
	}
	
	public int compareTo(CalendarEvent other) {
		if (!date.equals(other.date)){
			return date.compareTo(other.date);
		}
		else if (!time.equals(other.time)){
			return time.compareTo(other.time);
		}
		else{
			return 0;
		}
	}
	public int hashCode(){
		String code = "";
		int min = this.time.getMinute();
		if (min<10){
			code = "0" +min;}
		else{
			code = "" + min;
		}
		int hr = this.time.getHour();//Hour is already supposed to be 1-24, not 1-12, so we don't have to worry about this
		if (hr<10){
			code = code + "0" + hr;
		}
		else{
			code = code + hr;
		}
		int dte = 0;
		//January
		if (this.date.getMonth() >= 2){
			dte = 31;
		}
		boolean leap = false;
		if ((this.date.getYear() - 2016)%4==0){
			leap = true;
		}
		//February
		if (this.date.getMonth() >= 3 && leap == false){
			dte = dte + 28;
		}
		if (this.date.getMonth() >=3 && leap){
			dte = dte + 29;
		}
		//March
		if (this.date.getMonth() >= 4){
			dte = dte + 31;
		}
		//April
		if (this.date.getMonth() >= 5){
			dte = dte + 30;
		}
		//May
		if (this.date.getMonth() >= 6){
			dte = dte + 31;
		}
		//June
		if (this.date.getMonth() >= 7){
			dte = dte + 30;
		}
		//July
		if (this.date.getMonth() >= 8){
			dte = dte + 31;
		}
		//August
		if (this.date.getMonth() >= 9){
			dte = dte + 31;
		}
		//September
		if (this.date.getMonth() >= 10){
			dte = dte + 30;
		}
		//October
		if (this.date.getMonth() >= 11){
			dte = dte + 31;
		}
		//November
		if (this.date.getMonth() >= 12){
			dte = dte + 30;
		}
		dte = dte + this.date.getDay();
		code = code + dte;
		int year = this.date.getYear() - 2000;
		code = code + year;
		int result = Integer.parseInt(code);
		return result;
	}
}
