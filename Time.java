import java.io.*;
import java.util.*;

public class Time implements Comparable<Time>{
	private int hour, minute;
	boolean AM = true;
	
	public Time(){
		hour = 12;
		minute = 0;
	}
	
	public Time(int h, int m){
			setHour(h);
			setMinute(m);
	}
	public Time(Time otherTime){
		setHour(otherTime.hour);
		setMinute(otherTime.minute);
	}
	
	public void setHour(int h){
		if (h>0 && h<24){
			hour = h;
		}
		if (h>=12){
			AM = false;
		}
		if (h<12){
			AM = true;
		}
	}
	public void setMinute(int m){
		if (m >= 0 && m<60){
			minute = m;
		}
	}
	public String toString(){
		String str1="";
		String str2="";
		String M ="";
		if (minute<10){
			str2 = "0" +minute;
		}
		else{
			str2 = str2+minute;
		}
		if (AM){
			str1 = hour +":";
			M=" AM";
		}
		if (!AM && hour != 12){
			str1 = hour-12 + ":";
			M=" PM";
		}
		if (!AM && hour == 12){
			str1 = hour + ":";
			M = " PM";
		}
		String str = str1 + str2 + M;
		return str;
	}
	public void increment(){
		setHour(hour+1);
	}
	public void advance(int h){
		setHour(hour+h);
	}
	public int compareTo(Time otherTime){
		if (hour != otherTime.hour){
			return hour - otherTime.hour;
		}
		else if (minute != otherTime.minute){
			return minute - otherTime.minute;
		}
		else{
			return 0;
		}
	}
	public boolean equals(Time otherTime){
		return (this.compareTo(otherTime)==0);
	}
}
