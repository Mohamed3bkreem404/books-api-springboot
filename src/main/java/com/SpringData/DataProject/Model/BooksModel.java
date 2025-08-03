package com.SpringData.DataProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @NotBlank(message = "Author is required .")
    private String author;
    @NotBlank(message = "Title is required .")
    private String title;
    @Positive(message = "Number must be positive .")
    @Min(value = 1869 , message = "Year  starts from 1869 and higher .")
    @Max(value = 2010 , message = "Year ends from 2010 and lower .")

    private Integer year;


}
