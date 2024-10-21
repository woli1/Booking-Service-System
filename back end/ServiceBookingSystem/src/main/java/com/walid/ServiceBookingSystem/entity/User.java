package com.walid.ServiceBookingSystem.entity;

import com.walid.ServiceBookingSystem.DTO.UserDto;
import com.walid.ServiceBookingSystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String phone;
    private UserRole role;


    public UserDto getDto(){
        UserDto userDto=new UserDto();
        userDto.setId(id);
        userDto.setEmail(email);
        userDto.setRole(role);
        userDto.setName(name);

        return userDto;
    }

}
