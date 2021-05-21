package com.ps.FoodDelivery.service.impl;

import com.ps.FoodDelivery.dto.RestaurantDTO;
<<<<<<< HEAD
=======
import com.ps.FoodDelivery.exceptions.ApiExceptionResponse;
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.Restaurant;
import com.ps.FoodDelivery.repository.RestaurantRepository;
import com.ps.FoodDelivery.service.RestaurantService;
<<<<<<< HEAD
import com.ps.FoodDelivery.utils.FileExporterXML;
import com.ps.FoodDelivery.utils.FileExporter;
import com.ps.FoodDelivery.utils.FileExtensions;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
=======
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public List<Food> getRestaurantFood(Long id) {

        Restaurant tmp = restaurantRepository.findFirstById(id);
        return tmp.getFood();

    }

    @Override
    public List<Food> getRestaurantFood(String name) {
        return restaurantRepository.findFirstByName(name).getFood();
    }

    @Override
    public List<Restaurant> showAllRestaurants() {
        return this.restaurantRepository.showAllRestaurants();
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        this.restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant addRestaurantRet(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant findFirstByName(String name) {
        return restaurantRepository.findFirstByName(name);
    }

    @Override
    public Restaurant findFirstById(Long id) {
        return restaurantRepository.findFirstById(id);
    }

    @Override
    public String deleteById(Long id) {
        restaurantRepository.deleteById(id);
        return "okk";
    }

    @Override
    public String updateRestaurant(RestaurantDTO dto){
        Restaurant aux = restaurantRepository.findFirstById(dto.getId());

        aux.setName(dto.getName());
        aux.setLocation(dto.getLocation());

        restaurantRepository.save(aux);

        return "ok";

        }

<<<<<<< HEAD
    @Override
    public String exportRestaurants(List<Restaurant> restaurants, String fileType) {

        StringBuilder stringBuilder = new StringBuilder();
        Restaurant aux = new Restaurant();

        for(Restaurant i : restaurants){
            aux.setFood(i.getFood());
            aux.setName(i.getName());
            aux.setLocation(i.getLocation());
            FileExporter fileExporter = new FileExporterXML();
            stringBuilder.append(fileExporter.exportData(aux));
        }

        return stringBuilder.toString();

    }
=======


>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4


}
