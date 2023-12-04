package com.lcdw.user.service.entites;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro_user")
public class User {

    @Id
    @Column(name = "ID")
    private String UserId;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

    // other user properties that you want likh sakte hoo

    @Transient
    private List<Rating>ratings = new ArrayList<>();
}
