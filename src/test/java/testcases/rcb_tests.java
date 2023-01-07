package testcases;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class rcb_tests  {
	
	
	@Test(dataProvider = "getdata")
	public static void count_of_foreign_player(JSONArray array)
	{
		int count=0;
		
		for(int i=0;i<array.size();i++)
		{
			JSONObject obj=(JSONObject) array.get(i);
			String country=(String) obj.get("country");
			
			if(!country.equalsIgnoreCase("India"))
			{
				count++;
			}
			
		}
		
		System.out.println("count of foreign plapers " +count);
		assertEquals(count, 4);
		
	
	}
	
	
	@Test(dataProvider = "getdata")
	public static void count_of_wicket_keeper(JSONArray array)
	{
		int count_of_wicket=0;
		
		for(int i=0;i<array.size();i++)
		{
			JSONObject obj=(JSONObject) array.get(i);
			String country=(String) obj.get("role");
			
			if(country.equalsIgnoreCase("Wicket-keeper"))
			{
				count_of_wicket++;
			}
			
		}
		
		System.out.println("count of wicket keepers " +count_of_wicket);
		assertEquals(count_of_wicket, 1);
		
	
	}
	
	@DataProvider
	public static Object[] getdata() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\rcb.json"));
		JSONObject object=(JSONObject) obj;
		
		JSONArray array=(JSONArray) object.get("player");
		
		return new Object[] {array};
	}
	

}
