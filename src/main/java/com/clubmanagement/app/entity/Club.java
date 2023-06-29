package com.clubmanagement.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clubs")
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

    public Club(String name) {
        this.name = name;
    }

    //mappedBy points a field in a child class to connect with; also this annotation suggests there is a bidirectional mapping
    // in this case: in Player class there is a field club of type Club (Club club)
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "club", cascade = CascadeType.ALL)

}
