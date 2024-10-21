package com.walid.ServiceBookingSystem.services.authtication;

import com.walid.ServiceBookingSystem.DTO.SignupRequestDTO;
import com.walid.ServiceBookingSystem.DTO.UserDto;
import com.walid.ServiceBookingSystem.entity.User;
import com.walid.ServiceBookingSystem.enums.UserRole;
import com.walid.ServiceBookingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO){

        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
        user.setEmail(signupRequestDTO.getEmail());
        user.setLastname(signupRequestDTO.getLastname());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();

    }
    public Boolean presentByEmail(String email){
        return userRepository.findFirstByEmail(email)!=null;
    }
    public UserDto signupCompany(SignupRequestDTO signupRequestDTO){

        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
        user.setEmail(signupRequestDTO.getEmail());
        user.setLastname(signupRequestDTO.getLastname());
        user.setPassword(signupRequestDTO.getPhone());
        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();

    }


}
