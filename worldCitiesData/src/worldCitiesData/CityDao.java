package worldCitiesData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
List<City> cities;
	
	public CityDao() {
		cities = new ArrayList<City>();
	}
	
	public List<City> readCitiesFromCSV(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String record;
			String[] recordLst;
			
			do {
				record = br.readLine();
				if(record != null) {
					recordLst = record.split(",");
					City p = new City(Integer.parseInt(recordLst[0]), recordLst[1], Integer.parseInt(recordLst[2]),recordLst[3].trim() );
					cities.add(p);
				}			
			}while(record != null);
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return cities;
	}

	public List<City> getAllcities() {
		return cities;
	}

}
