package Day3_Tasks.Ex2_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        DataDAOImpl i = new DataDAOImpl();
        System.out.println("---------- All Cities Names ----------");
        ArrayList<City> all_cities = i.getAllCities();
        for (City city : all_cities){
            System.out.print(city.getName()+" ");
        }

        System.out.println("\n--------- All Countries Names ------------");
        ArrayList<Country> all_countries = i.getAllCountries();
        for (Country country : all_countries){
            System.out.print(country.getName()+" ");
        }

        System.out.println("\n --------- Cities Per Country -----------");
        for (String country : i.citiesPerCountry().keySet()){
            System.out.println(country);
            for (City city : i.citiesPerCountry().get(country)){
                System.out.print(city.getName() + " ");
            }
            System.out.println();
        }

        System.out.println("----------- Cities Sorted by Population ------------");
        System.out.println(i.getSortedByPopulation("ARG"));

        System.out.println("----------- All Countries Populations ------------");
        for (String country : i.getAllCountriesPopulation().keySet()){
            System.out.println(country);
            System.out.println(i.getAllCountriesPopulation().get(country));
        }

        System.out.println("----------- All Populations Average ------------");
        System.out.println(i.allPopulationsAvg());

        System.out.println("----------- Max Population Country ------------");
        System.out.println(i.maxPopulationOfAll().getName() + " : " + i.maxPopulationOfAll().getPopualtion());

        System.out.println("----------- Highest Population City Per Country ------------");
        i.highestPopulationPerCountry().forEach((country, population) ->{
            System.out.println(country + " : " + population);
        } );


    }
}
