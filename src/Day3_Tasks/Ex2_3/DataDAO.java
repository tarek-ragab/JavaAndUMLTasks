package Day3_Tasks.Ex2_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DataDAO {
    ArrayList<City> getAllCities() throws IOException;
    ArrayList<Country> getAllCountries() throws IOException;
    Map<String, List<City>> citiesPerCountry();
    ArrayList<City> getSortedByPopulation(String code);
    HashMap<String, Double> getAllCountriesPopulation();
    double allPopulationsAvg();
    Country maxPopulationOfAll();
    HashMap<String, Integer> highestPopulationPerCountry();
    City highestPopulationCapital();
}
