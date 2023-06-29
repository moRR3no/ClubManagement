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
//
//
//
//		Set<Player> players = new HashSet<>();
//		players.add(new Player("Vinicius Jr", 11));
//		players.add(new Player("Modrić", 10));
//		players.add(new Player("Kroos", 8));
//		players.add(new Player("Rodrygo", 7));
//		players.add(new Player("Courtois", 1));
//		Club realMadrid = new Club("Real Madrid");
//		realMadrid.setPlayers(players);
//
//		playerService.savePlayers(players);
//		clubService.save(realMadrid);
//
////
//
////		realMadrid.setPlayers(players);
////		clubService.save(realMadrid);
//
//	}
}
