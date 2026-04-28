package com.example.it210dgnl005.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Spacecraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name Không được để trống")
    @Size(min = 5, max = 150, message = "Không được ngắn hơn 5 ký tự & dài hơn 150 ký tự")
    private String name;

    @Column(name = "series")
    @NotBlank(message = "Series không được để trống")
    private String series;

    @Column(name = "date")
    @NotNull(message = "date không được để trống")
    @PastOrPresent(message = "date không được ở tương lai")
    private LocalDate date;
}
