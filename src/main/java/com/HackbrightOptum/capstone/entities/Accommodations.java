package com.HackbrightOptum.capstone.entities;

import com.HackbrightOptum.capstone.dtos.AccommodationsDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Accommodations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Accommodations {
    @Id
    @GeneratedValue
    @Column(name = "Accommodation_ID")
    private Long accommodationId;

    @Column(name = "Accommodation_Name")
    private String accommodationName;

    @Column(name = "Accommodation_Description")
    private String accommodationDescription;

    public void addStudentAccommodation(StudentAccommodation studentAccommodation) {
        studentAccommodation.setAccommodation(this);
        this.getStudentAccommodationList().add(studentAccommodation);
    }
    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL)
    private List<StudentAccommodation> studentAccommodationList;

    public Accommodations(Accommodations accommodations){
        if(accommodations.getAccommodationId() != null){
            this.accommodationId = accommodations.getAccommodationId();
        }
        if(accommodations.getAccommodationName() != null){
            this.accommodationName = accommodations.getAccommodationName();
        }
        if(accommodations.getAccommodationDescription() != null){
            this.accommodationDescription = accommodations.getAccommodationDescription();
        }
        if(accommodations.getStudentAccommodationList() != null){
            this.studentAccommodationList = accommodations.getStudentAccommodationList();
        }
    }
}
