package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleInput {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String getString(){
		
		String s="";
		
		try {
			s=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	public static int getInt(){
		
		int i=0;
		
		try {
			i=Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input,Need INTEGER");
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	public static float getFloat(){
		
		float f=0;
		
		try {
			f=Float.parseFloat(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input,Need FLOAT");
			f=getFloat();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}
	public static String getDate(){
		String s="";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			s = br.readLine();
			Date date = format.parse(s);
		} 
        catch (IOException e1) {
			e1.printStackTrace();
		}catch (ParseException e) {
			System.out.println("Wrong date format");
			s=getDate();
		}
		return s;
	}
}
