package com.lcdw.user.service.entites;


import com.lcwd.hotel.entities.Hotel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;  // dependancy add kiya hai eski ya fir in short direct yahan class bao entities mai aur same Hotel ka paramemeter dalo



}
