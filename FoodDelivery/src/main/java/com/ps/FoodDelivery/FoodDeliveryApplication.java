package com.ps.FoodDelivery;

import com.ps.FoodDelivery.GUI.Login;
import com.ps.FoodDelivery.model.*;
import com.ps.FoodDelivery.repository.*;
import com.ps.FoodDelivery.service.*;
import com.ps.FoodDelivery.service.impl.RestaurantServiceImpl;
import com.ps.FoodDelivery.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@SpringBootApplication
public class FoodDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApplication.class, args);
	}



	@Bean
	CommandLineRunner init(UserRepository userRepository,
						   FoodRepository foodRepository,
						   RestaurantRepository restaurantRepository,
						   FoodOrderRepository foodOrderRepository,
						   FoodTransportRepository foodTransportRepository,
						   FoodTransportService foodTransportService,
						   OfferRepository offerRepository,
						   UserServiceImpl userService,
						   RestaurantServiceImpl restaurantService,
						   FoodOrderService foodOrderService,
						   FoodService foodService,
						   OfferService offerService
	){

		return args -> {

		User user = User.builder().
				firstName("Andrei").
				lastName("Hulea").
				email("admin@mail.com").
				password("123").
				phoneNumber("123123123").
				accountType(User.roles.ADMIN).
				build();
			userRepository.save(user);

		User user2 = User.builder().
				firstName("User").
				lastName("user").
				email("user@mail.com").
				password("123").
				phoneNumber("321312312").
				accountType(User.roles.USER).
				build();
			userRepository.save(user2);

		System.out.println(user.getAccountType());

		Restaurant panini = Restaurant.builder().
						name("Restaurant1").
						location("alba").
						build();
		restaurantRepository.save(panini);

			Restaurant panini2 = Restaurant.builder().
					name("Restaurant2").
					location("cluj").
					build();
			restaurantRepository.save(panini);

		Food cranci = Food.builder().
				name("cartofi").
				price(22.0).
				remainingStock(1000).
				build();

		Food sosPanini = Food.builder().
				name("sos panini").
				price(2.0).
				remainingStock(1000).
				build();

			Food sosPanini3 = Food.builder().
					name("shaorma").
					price(13.0).
					remainingStock(1000).
					build();

			Food sosPanini4 = Food.builder().
					name("foietaj lidl").
					price(200.0).
					remainingStock(5).
					build();
		List<Food> paniniFood = new ArrayList<>();
		List<Food> foodList = new ArrayList<>();
		paniniFood.add(cranci);
		paniniFood.add(sosPanini);


		foodList.add(cranci);
		foodList.add(sosPanini);
		foodList.add(sosPanini3);

		panini.setFood(paniniFood);
		panini2.setFood(foodList);

		foodRepository.save(cranci);
		foodRepository.save(sosPanini);
		foodRepository.save(sosPanini3);
		foodRepository.save(sosPanini4);
		restaurantRepository.save(panini);
		restaurantRepository.save(panini2);
		FoodOrder auxx = FoodOrder.builder().foodList(paniniFood).user(user2).build();
		foodOrderRepository.save(auxx);


		List<Food> foodlist2 = new ArrayList<>();
		Food foood = Food.builder().
				name("asdasdasd").
				price(2.0).
				remainingStock(1000).
				build();

		foodlist2.add(foood);

		foodRepository.save(foood);

		FoodOrder auxx2 = FoodOrder.builder().
				foodList(paniniFood).
				user(user).build();

		foodOrderRepository.save(auxx2);

		paniniFood.add(sosPanini4);
		auxx2.setFoodList(paniniFood);
		foodOrderRepository.save(auxx2);


	/*	FoodTransport auxxx = FoodTransport.builder().
				location("alb").
				price(foodOrderService.computePrice(auxx2)).
				departure(LocalTime.of(17,20)).
				arrival(LocalTime.of(17,20)).
				user(user2).
				foodOrder(auxx2).
				build();
		foodTransportRepository.save(auxxx);
			System.out.println(foodTransportRepository.findByUser(user2));*/


		Offer auxxxx = Offer.builder().reduction(50).user(user).build();
		offerRepository.save(auxxxx);
		for(Offer i : offerRepository.showAllOffers())
			System.out.println(i.getReduction());

			/*System.setProperty("java.awt.headless", "false");
			Login sef = new Login(userRepository,
					userService,
					foodOrderRepository,
					offerRepository,
					restaurantRepository,
					foodTransportService,
					foodService,
					restaurantService,
					foodOrderService,
					offerService);*/

			/*System.out.println(foodOrderService.findFirstByUser(userService.findById(Long.valueOf(2))).toString());
			foodOrderService.removeFoodRet(
					foodOrderService.findFirstByUser(userService.findById(Long.valueOf(2))), foodService.findFirstByName("cartofi"));
			System.out.println(foodOrderService.findFirstByUser(userService.findById(Long.valueOf(2))).toString());*/

		};





	}




}
