package com.clubmanagement.app;

import com.clubmanagement.app.repository.ClubRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ClubRepository clubRepository;

//	@Test
//	void saveTestClubWithPlayers () {
//
//		//create Club object
//		Club club = new Club("Real Madrid");
//
//		Set<Player> players = new HashSet<>();
//		players.add(new Player("Vinicius Jr", 11));
//		players.add(new Player("Modrić", 10));
//		players.add(new Player("Kroos", 8));
//		players.add(new Player("Rodrygo", 7));
//		players.add(new Player("Courtois", 1));
//
//		club.setPlayers(players);
//
//
//		Club club1 = new Club("Liverpool FC");
//
//		Set<Player> players1 = new HashSet<>();
//		players.add(new Player("Salah", 10));
//		players.add(new Player("Van Dijk", 4));
//		players.add(new Player("Allison", 1));
//		players.add(new Player("Alexander-Arnold", 67));
//		players.add(new Player("Robertson", 23));
//		club1.setPlayers(players1);
//
//
//		Club club2 = new Club("FC Barcelona");
//
//		Set<Player> players2 = new HashSet<>();
//		players.add(new Player("Messi", 10));
//		players.add(new Player("Lewandowski", 9));
//		players.add(new Player("Pedri", 8));
//		players.add(new Player("Gavi", 6));
//		players.add(new Player("Ter-Stegen", 1));
//		club2.setPlayers(players2);
//
//	}

}
