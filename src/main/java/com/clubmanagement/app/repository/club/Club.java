package com.clubmanagement.app.repository.club;

import com.clubmanagement.app.repository.player.Player;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "club")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Player.class)
    @JoinColumn(name = "club_players_fk", referencedColumnName = "id")
    private List<Player> players;


}
