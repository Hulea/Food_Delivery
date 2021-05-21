package com.ps.FoodDelivery;

<<<<<<< HEAD
=======
import com.ps.FoodDelivery.GUI.Login;
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
import com.ps.FoodDelivery.model.*;
import com.ps.FoodDelivery.repository.*;
import com.ps.FoodDelivery.service.*;
import com.ps.FoodDelivery.service.impl.RestaurantServiceImpl;
import com.ps.FoodDelivery.service.impl.UserServiceImpl;
<<<<<<< HEAD
import com.ps.FoodDelivery.utils.PasswordEncryption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;
=======
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
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4


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

<<<<<<< HEAD

		String asd = "asd";

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
		User user = User.builder().
				firstName("Andrei").
				lastName("Hulea").
				email("admin@mail.com").
<<<<<<< HEAD
				password(PasswordEncryption.encrypt("123",asd)).
				phoneNumber("123123123")
				.key1(asd)
				.accountType(User.roles.ADMIN)

				.build();
=======
				password("123").
				phoneNumber("123123123").
				accountType(User.roles.ADMIN).
				build();
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
			userRepository.save(user);

		User user2 = User.builder().
				firstName("User").
				lastName("user").
				email("user@mail.com").
<<<<<<< HEAD
				password(PasswordEncryption.encrypt("123",asd)).
				phoneNumber("321312312").
				accountType(User.roles.USER)
				.key1(asd)
				.build();
=======
				password("123").
				phoneNumber("321312312").
				accountType(User.roles.USER).
				build();
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
			userRepository.save(user2);

		System.out.println(user.getAccountType());

		Restaurant panini = Restaurant.builder().
<<<<<<< HEAD
						name("Panini").
=======
						name("Restaurant1").
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
						location("alba").
						build();
		restaurantRepository.save(panini);

<<<<<<< HEAD
		Restaurant panini2 = Restaurant.builder().
				name("Pub Skit").
				location("alba").
				build();
		restaurantRepository.save(panini);


		Restaurant panini3 = Restaurant.builder().
				name("La conac")
				.location("alba")
				.build();
		restaurantRepository.save(panini3);

		Food cranci = Food.builder().
				name("Cartofi").
=======
			Restaurant panini2 = Restaurant.builder().
					name("Restaurant2").
					location("cluj").
					build();
			restaurantRepository.save(panini);

		Food cranci = Food.builder().
				name("cartofi").
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
				price(22.0).
				remainingStock(1000).
				build();

		Food sosPanini = Food.builder().
<<<<<<< HEAD
				name("Sos panini").
=======
				name("sos panini").
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
				price(2.0).
				remainingStock(1000).
				build();

<<<<<<< HEAD
		Food sosPanini3 = Food.builder().
				name("Shaorma").
				price(13.0).
				remainingStock(1000).
				build();

		Food sosPanini4 = Food.builder().
				name("Foietaj Lidl").
				price(200.0).
				remainingStock(5).
				build();

		Food sosPanini5 = Food.builder()
				.name("Paste")
				.price(30.0)
				.remainingStock(50)
				.build();

		Food sosPanini6 = Food.builder()
				.name("Pizza")
				.price(28.0)
				.remainingStock(30)
				.build();



		foodRepository.save(cranci);
		foodRepository.save(sosPanini);
		foodRepository.save(sosPanini3);
		foodRepository.save(sosPanini4);
		foodRepository.save(sosPanini5);
		foodRepository.save(sosPanini6);

		List<Food> paniniFood = new ArrayList<>();
		List<Food> foodList = new ArrayList<>();
		List<Food> conacFood = new ArrayList<>();
		paniniFood.add(cranci);
		paniniFood.add(sosPanini);
		conacFood.add(sosPanini5);
		conacFood.add(sosPanini6);
=======
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

>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4

		foodList.add(cranci);
		foodList.add(sosPanini);
		foodList.add(sosPanini3);

		panini.setFood(paniniFood);
		panini2.setFood(foodList);
<<<<<<< HEAD
		panini3.setFood(conacFood);

		restaurantRepository.save(panini);
		restaurantRepository.save(panini2);
		restaurantRepository.save(panini3);

=======

		foodRepository.save(cranci);
		foodRepository.save(sosPanini);
		foodRepository.save(sosPanini3);
		foodRepository.save(sosPanini4);
		restaurantRepository.save(panini);
		restaurantRepository.save(panini2);
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
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
<<<<<<< HEAD

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
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
