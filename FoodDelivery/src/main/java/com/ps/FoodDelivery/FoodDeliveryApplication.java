package com.ps.FoodDelivery;

import com.ps.FoodDelivery.model.*;
import com.ps.FoodDelivery.repository.*;
import com.ps.FoodDelivery.service.*;
import com.ps.FoodDelivery.service.impl.RestaurantServiceImpl;
import com.ps.FoodDelivery.service.impl.UserServiceImpl;
import com.ps.FoodDelivery.utils.PasswordEncryption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;


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


			String asd = "asd";

			User user = User.builder().
					firstName("Andrei").
					lastName("Hulea").
					email("admin@mail.com").
					password(PasswordEncryption.encrypt("123",asd)).
					phoneNumber("123123123")
					.key1(asd)
					.accountType(User.roles.ADMIN)

					.build();
			userRepository.save(user);

			User user2 = User.builder().
					firstName("User").
					lastName("user").
					email("user@mail.com").
					password(PasswordEncryption.encrypt("123",asd)).
					phoneNumber("321312312").
					accountType(User.roles.USER)
					.key1(asd)
					.build();
			userRepository.save(user2);

			System.out.println(user.getAccountType());

			Restaurant panini = Restaurant.builder().
					name("Panini").
					location("alba").
					build();
			restaurantRepository.save(panini);

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
					price(22.0).
					remainingStock(1000).
					build();

			Food sosPanini = Food.builder().
					name("Sos panini").
					price(2.0).
					remainingStock(1000).
					build();

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

			foodList.add(cranci);
			foodList.add(sosPanini);
			foodList.add(sosPanini3);

			panini.setFood(paniniFood);
			panini2.setFood(foodList);
			panini3.setFood(conacFood);

			restaurantRepository.save(panini);
			restaurantRepository.save(panini2);
			restaurantRepository.save(panini3);

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