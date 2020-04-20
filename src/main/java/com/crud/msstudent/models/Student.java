package com.crud.msstudent.models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty(message = "First name is required")
    private String firstname;
    
    @NotEmpty(message = "Last name is required")
    private String lastname;
    
    @Column(nullable = true, name = "email")
    private String email;

}