package com.SpringData.DataProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "accs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Username is required.")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password is required.")
    private String password;


}
