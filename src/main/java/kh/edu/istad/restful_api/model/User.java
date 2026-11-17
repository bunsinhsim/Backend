package kh.edu.istad.restful_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name ="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)//number auto increment
   private UUID id;
    @Column(nullable = false,unique = true,length = 30)//user name
   private String userName;
    @Column(nullable = false)
   private String password;
    @Column(nullable = false,length = 40)
   private String fullName;
}