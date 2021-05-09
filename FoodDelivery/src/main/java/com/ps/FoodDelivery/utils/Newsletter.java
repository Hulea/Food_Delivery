package com.ps.FoodDelivery.utils;

import com.ps.FoodDelivery.model.Food;
import com.ps.FoodDelivery.model.Restaurant;
import com.ps.FoodDelivery.service.EmailSenderService;
import com.ps.FoodDelivery.service.RestaurantService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Random;


@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled",matchIfMissing = true)
public class Newsletter {


    private final RestaurantService restaurantService;
    private final EmailSenderService emailSenderService;


    public Newsletter(RestaurantService restaurantService, EmailSenderService emailSenderService) {
        this.restaurantService = restaurantService;
        this.emailSenderService = emailSenderService;
    }

    //@Scheduled(initialDelay = 1000L,fixedDelay = 2000L)
    @Scheduled(cron ="0 */1 * * * *")
    void newsletter() throws InterruptedException{

        Random rand = new Random();

        List<Restaurant> restaurantList = restaurantService.showAllRestaurants();
        int rand1 = rand.nextInt(restaurantList.size());
        Restaurant restaurantAux = restaurantList.get(rand1);


        List<Food> foodList = restaurantAux.getFood();
        int rand2 = rand.nextInt(foodList.size());
        Food foodAux = foodList.get(rand2);

        String letter =
                "Get " + foodAux.getName() +
                        " at only " + foodAux.getPrice() +
                        " from " + restaurantAux.getName();

        //System.out.println(letter);

        emailSenderService.sendSimpleEmail("dummy.mail312@gmail.com",
                letter,
                "FoodDelivery App Limited Time Offer");
    }


}
