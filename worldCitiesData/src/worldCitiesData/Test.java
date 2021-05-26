package worldCitiesData;

import java.util.List;
import java.io.IOException;
import java.util.Map;

public class Test {

	public static void main(String[] args) throws IOException {
		
		//an application that reads two files for cities and countries and store each in a List.
		CountryDao countyDAO = new CountryDao();
		List<Country> countries = countyDAO.readCountriesFromCSV("C:\\Users\\saraz\\Desktop\\Countries.csv");
		
		CityDao cityDAO = new CityDao();
		List<City> cities = cityDAO.readCitiesFromCSV("C:\\Users\\saraz\\Desktop\\Cities.csv");
		
		
		//A map that uses the country code as keys and a list of cities as the value for each country.
		Map<String, List<City>> cityMap = DataOperation.mapCountryToCity(countries, cities);
		System.out.println(cityMap);
		
		//For a given country code (from Console) sort the cities according to the population
		DataOperation.getCountryInfoConsole(cities);
		
		//Get a List of countries population
		List<Integer> popOFCountries= DataOperation.populationOFCountries(countries);
		System.out.println(popOFCountries);
		
		//The average countries population
		int avg = DataOperation.avgCountryPopulation(countries);
		System.out.println(avg);
		
		//The maximum countries population
		int max = DataOperation.maxCountryPopulation(countries);
		System.out.println(max);
		
		//Highest population city of each country
		List<City> maxPopCities= DataOperation.maxPopCities(countries, cities);
		System.out.println(maxPopCities);
		
		//Highest population capital
		City highPopCapital = DataOperation.maxPopCapital(countries, cities);
		System.out.println(highPopCapital);
				

	}

}
