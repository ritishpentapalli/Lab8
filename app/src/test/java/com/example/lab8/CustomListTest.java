package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * create 2 city objects
     * add one to list, dont add the other
     * check if the one added to list is in the list
     • check if the other one is not in list
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City cityInList = new City("Edmonton", "Alberta");
        City cityNotInList = new City("Regina", "Saskatchewan");
        list.addCity(cityInList);
        assertEquals(true, list.hasCity(cityInList));
        assertEquals(false, list.hasCity(cityNotInList));
    }

    /**
     * add city object to list
     * delete it from list
     * check if it actually has been deleted
     * try deleting it again, check if this raises an error (since its not in the list anymore)
     */
    @Test
    void deleteCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(false, list.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });
    }

    /**
     * add city object to (empty) list
     * check if list size is now 1
     */
    @Test
    void countCitiesTest() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        assertEquals(1, list.countCities());
    }

}
