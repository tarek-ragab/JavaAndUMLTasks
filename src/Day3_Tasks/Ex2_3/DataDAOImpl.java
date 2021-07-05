package Day3_Tasks.Ex2_3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataDAOImpl implements DataDAO{

    ArrayList<City> cities;
    ArrayList<Country> countries;

    DataDAOImpl() throws IOException {
        cities = getAllCities();
        countries = getAllCountries();
    }

    @Override
    public ArrayList<City> getAllCities() throws IOException {
        ArrayList<City> myCities= new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("Day3_Ex2_3_Cities.csv"));
        String line = br.readLine();
        String[] cityData = line.split(",");
        City city = new City();
        city.setId(Integer.parseInt(cityData[0]));
        city.setName(cityData[1]);
        city.setPopulation(Integer.parseInt(cityData[2]));
        city.setCountryCode(cityData[3]);
        myCities.add(city);
        while (line != null){
            line = br.readLine();
            if (line != null){
                cityData = line.split(",");
                city = new City();
                city.setId(Integer.parseInt(cityData[0]));
                city.setName(cityData[1]);
                city.setPopulation(Integer.parseInt(cityData[2]));
                city.setCountryCode(cityData[3]);
                myCities.add(city);
            }

        }
        return myCities;
    }

    @Override
    public ArrayList<Country> getAllCountries() throws IOException {
        ArrayList<Country> myCountries= new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("Day3_Ex2_3_Countries.csv"));
        String line = br.readLine();
        String[] countryData = line.split(",");
        Country country = new Country();
        country.setCapital(countryData[0]);
        country.setCode(countryData[1]);
        country.setName(countryData[2]);
        country.setContinent(countryData[3]);
        country.setSurfaceArea(Double.parseDouble(countryData[4]));
        country.setPopualtion(Integer.parseInt(countryData[5]));
        country.setGnp(Double.parseDouble(countryData[6]));
        myCountries.add(country);
        while (line != null){
            line = br.readLine();
            if(line != null){
                countryData = line.split(",");
                country = new Country();
                country.setCapital(countryData[0]);
                country.setCode(countryData[1]);
                country.setName(countryData[2]);
                country.setContinent(countryData[3]);
                country.setSurfaceArea(Double.parseDouble(countryData[4]));
                country.setPopualtion(Double.parseDouble(countryData[5]));
                country.setGnp(Double.parseDouble(countryData[6]));
                myCountries.add(country);
            }
        }
        return myCountries;
    }

    @Override
    public HashMap<String, List<City>> citiesPerCountry() {
       return (HashMap<String, List<City>>) cities.stream().collect(Collectors.groupingBy(City::getCountryCode));
    }

    @Override
    public ArrayList<City> getSortedByPopulation(String code) {
        HashMap<String,List<City>> citiesPerCountry = (HashMap<String, List<City>>) cities.stream().collect(Collectors.groupingBy(City::getCountryCode));
        HashMap<String,List<City>> afterSort = new HashMap<>();
        citiesPerCountry.forEach((s, cities) -> {
            afterSort.put(s,cities.stream().sorted(Comparator.comparingDouble(City::getPopulation)).collect(Collectors.toList()));
        });
        afterSort.forEach((c,cities)-> {
            System.out.println(c);
            for (City city : cities){
                System.out.print(city.getName());
            }
            System.out.println();
        });
        return (ArrayList<City>) afterSort.get(code);
    }

    @Override
    public HashMap<String, Double> getAllCountriesPopulation() {
        return (HashMap<String, Double>) countries.stream().collect(Collectors.toMap(Country::getName,Country::getPopualtion));
    }

    @Override
    public double allPopulationsAvg() {
        return countries.stream().collect(Collectors.averagingDouble(Country::getPopualtion));
    }

    @Override
    public Country maxPopulationOfAll() {
        Country country = countries.stream().max(Comparator.comparingDouble(Country::getPopualtion)).get();
        return country;
    }

    @Override
    public HashMap<String, Integer> highestPopulationPerCountry() {
        HashMap<String,List<City>> citiesPerCountry = (HashMap<String, List<City>>) cities.stream().collect(Collectors.groupingBy(City::getCountryCode));
        HashMap<String, Integer> finalResult = new HashMap<>();
        citiesPerCountry.forEach((s, cities) -> {
            City max = cities.stream().max(Comparator.comparingDouble(City::getPopulation)).get();
            finalResult.put(s,max.getPopulation());
        });
        return finalResult;
    }

    @Override
    public City highestPopulationCapital() {
        Map<String,String> countries_capitals = countries.stream().collect(Collectors.toMap(Country::getCode, Country::getCapital));
        List<City> capitals = cities.stream().filter(c-> countries_capitals.containsValue(c.getId())).collect(Collectors.toList());
        City max = capitals.stream().max(Comparator.comparingDouble(City::getPopulation)).get();
        return max;
    }
}
