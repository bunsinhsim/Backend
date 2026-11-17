package kh.edu.istad.restful_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//number auto increment
      private Integer id;
       @Column(unique = true,length = 50)
      private String email;
       @Column(unique = true,length = 10)
      private String phone_Number;
       @Column(nullable = false)
    private Boolean status;

}
