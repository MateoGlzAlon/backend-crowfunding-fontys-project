package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.LoginService;
import com.fontys.crowdfund.exception.InvalidCredentialsException;
import com.fontys.crowdfund.config.security.token.AccessTokenEncoder;
import com.fontys.crowdfund.config.security.token.impl.AccessTokenImpl;
import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOLogin;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOLogin;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;

    @Override
    public OutputDTOLogin login(InputDTOLogin loginRequest) {
        UserEntity user = userRepository.findByEmail(loginRequest.getUsername());
        System.out.println(1);

        if (user == null) {
            throw new InvalidCredentialsException();
        }
        System.out.println(2);

        if (!matchesPassword(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }
        System.out.println(3);


        String accessToken = generateAccessToken(user);
        System.out.println(4);

        return OutputDTOLogin.builder().accessToken(accessToken).build();
    }

    private boolean matchesPassword(String rawPassword, String encodedPassword) {

        System.out.println("m1");
        System.out.println("rawPassword: " + rawPassword);
        System.out.println("encodedPassword: " + encodedPassword);


        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String generateAccessToken(UserEntity user) {
        Long studentId = Long.valueOf(user.getId());
        List<String> role = new ArrayList<>();
        role.add(user.getRole());

        return accessTokenEncoder.encode(new AccessTokenImpl(studentId, role));
    }

}
