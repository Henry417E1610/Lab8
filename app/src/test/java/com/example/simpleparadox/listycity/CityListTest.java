package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }
    
    @Test
    void addException(){
        CityList cityList = mockCityList();
        final City city = new City("Toronto","Ontario");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class,() -> {
            cityList.add(city);
        });
    }

    @Test
    void hasCityTest(){
        CityList cityList = mockCityList();
        City city = new City("Vancouver","British Columbia");
        //assertFalse(cityList.hasCity(city));
        //cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }
    
    @Test
    void getCityTest(){
        CityList cityList = mockCityList();
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));
        City city=new City("Charlottetown","Prince Edward Island");
        cityList.add(city);

        assertEquals(0,city.compareTo(cityList.getCities().get(0)));
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(1)));
    }
}
