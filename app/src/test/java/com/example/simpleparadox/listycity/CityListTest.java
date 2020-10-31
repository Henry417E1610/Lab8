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
        assertTrue(cityList.hasCity(new City("Regina", "Alberta")));
    }
    
    @Test
    void addException(){
        CityList cityList = mockList();
        final City city = new City("Toronto","Ontario");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class,() -> {
            cityList.add(city);
        });
    }

    @Test
    void hasCityTest(){
        CityList cityList = mockList();
        City city = new City("Vancouver","British Columbia");
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }
    
    @Test
    void getCityTest(){
        CityList cityList = mockList();
        assertEquals(0,mock().compareTo(cityList.getCities().get(0)));
        City city=new City("Charlottetown","Prince Edward Island");
        cityList.add(city);

        assertEquals(0,city.compareTo(cityList.getCities().get(0)));
        assertEquals(0,mock().compareTo(cityList.getCities().get(1)));
    }
}
