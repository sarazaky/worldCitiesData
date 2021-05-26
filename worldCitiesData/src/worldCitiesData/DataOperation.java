package worldCitiesData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataOperation {
	
	//A map that uses the country code as keys and a list of cities as the value for each country.
	public static Map<String, List<City>> mapCountryToCity(List<Country> countries, List<City> cities){
		
		Map<String , List<City>> cityMap = new HashMap<>();
		for(Country cont: countries) {
			String code = cont.getCode();
			List<City> cityList = cities.stream().filter(c -> c.getCountryCode().equals(code)).collect(Collectors.toList());
			cityMap.put(code, cityList);
		}
		return cityMap;	
	}
	
	//For a given country code (from Console) sort the cities according to the population
	public static void getCountryInfoConsole(List<City> cities) throws IOException {
		
		System.out.println("Enter Country code: ");
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(r);
		String counrtyCode =br.readLine();
		cities.stream().filter(c -> c.getCountryCode().equals(counrtyCode)).sorted(Comparator.comparingInt(City::getPopulation).reversed()).forEach(c -> System.out.println(c));

	}
	
	//Get a List of countries population
	public static List<Integer> populationOFCountries(List<Country> countries){
		
		return countries.stream().map(Country::getPopulation).collect(Collectors.toList());
	}
	
	//The average countries population
	public static int avgCountryPopulation(List<Country> countries) {
		
		List<Integer> pop = populationOFCountries(countries);
		int avg =(int) pop.stream().mapToInt(p -> p).average().getAsDouble();
		return avg;
	}
	
	//The maximum countries population
	public static int maxCountryPopulation(List<Country> countries) {
		
		List<Integer> pop = populationOFCountries(countries);
		int max = pop.stream().mapToInt(p -> p).max().getAsInt();
		return max;
		
	}
	
	//Highest population city of each country
	public static List<City> maxPopCities(List<Country> countries, List<City> cities){
		Map<String , List<City>> cityMap = mapCountryToCity(countries, cities);
		
		List<City> maxPopCityList = new ArrayList<City>();
		for(Map.Entry<String, List<City>> entry : cityMap.entrySet()) {
//			City maxPopCity = entry.getValue().stream().max(Comparator.comparingInt(City::getPopulation)).orElse(null);
//			maxPopCityList.add(maxPopCity);
			
			List<City> l = entry.getValue().stream().sorted(Comparator.comparingInt(City::getPopulation)
							.reversed()).collect(Collectors.toList());
			if (l.size() != 0) {
				maxPopCityList.add(l.get(0));
			}
		}
		return maxPopCityList;
	}
	
	//Highest population capital
	public static City maxPopCapital(List<Country> countries, List<City> cities) {
		
		List<Integer> capitalIDs = countries.stream().map(Country::getCapital).collect(Collectors.toList());
		
//		City highPopCapital = cities.stream().filter(c -> capitalIDs.contains(c.getId())).
//				max(Comparator.comparingInt(City::getPopulation)).orElse(null);

		List<City> l = cities.stream().filter(c -> capitalIDs.contains(c.getId())).sorted(Comparator.
				comparingInt(City::getPopulation).reversed()).collect(Collectors.toList());
		
		City highPopCapital = l.get(0);
		
		return highPopCapital;
	}
	
	
	
	
	
	
	
	
	

}