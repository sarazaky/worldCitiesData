package worldCitiesData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {
	List<Country> countries;
	
	public CountryDao() {
		countries = new ArrayList<Country>();
	}
	
	public List<Country> readCountriesFromCSV(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String record;
			String[] recordLst;
			
			do {
				record = br.readLine();
				if(record != null) {
					recordLst = record.split(",");
					Country p = new Country(recordLst[0], recordLst[1], recordLst[2],Integer.parseInt(recordLst[3]) , Double.parseDouble(recordLst[4]),Double.parseDouble(recordLst[5]),Integer.parseInt(recordLst[6]));
					countries.add(p);
				}			
			}while(record != null);
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return countries;
	}

	public List<Country> getAllCountries() {
		return countries;
	}
	
	

}
