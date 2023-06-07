package com.clubmanagement.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}


	/**
	 * Probably better way to insert data is doing it thorugh Postman in JSON Body
	 */
//	@Bean
//	public CommandLineRunner commandLineRunner (ClubService clubService, PlayerService playerService) {
//		return runner ->
//				createPlayerClub(clubService, playerService);
//	}
//
//	private void createPlayerClub(ClubService clubService, PlayerService playerService) {
//		Club realMadrid = new Club("Real Madrid");
//		Player player20 = new Player("Vinicius Jr" , 20);
//		Player player10 = new Player("Luka Modric" , 10);
//		Player player9 = new Player("Karim Benzema" , 9);
//		Player player1 = new Player("Thibaut Courtois" , 1);
//
//		clubService.save(realMadrid);
//
//		player1.setClub(realMadrid);
//		player10.setClub(realMadrid);
//		player9.setClub(realMadrid);
//		player20.setClub(realMadrid);
//
//		playerService.save(player20);
//		playerService.save(player1);
//		playerService.save(player9);
//		playerService.save(player10);
//	}
}
