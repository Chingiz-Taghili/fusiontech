package com.multishop.fusiontech.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "testimonials")
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String position;
    private String image;
    @Column(length = 400)
    private String description;
}