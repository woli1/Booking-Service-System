package com.walid.ServiceBookingSystem.services.authtication;

import com.walid.ServiceBookingSystem.DTO.SignupRequestDTO;
import com.walid.ServiceBookingSystem.DTO.UserDto;

public interface AuthService {

    UserDto signupClient(SignupRequestDTO signupRequestDTO);
    Boolean presentByEmail(String email);
    UserDto signupCompany(SignupRequestDTO signupRequestDTO);


}
