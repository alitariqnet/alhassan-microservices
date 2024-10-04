package org.oril.services;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.oril.entities.AuthRequest;
import org.oril.entities.AuthResponse;
import org.oril.entities.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class AuthService {

    private final RestTemplate restTemplate;
    private final JwtUtil jwtUtil;

    public AuthResponse register(AuthRequest request) {
        String accessToken = null;
        String refreshToken = null;
        try {
            //do validation if user exists in DB
            request.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
            UserVO registeredUser = restTemplate.postForObject("http://user-service/users", request, UserVO.class);
            System.out.println("registered user -> "+registeredUser);
            accessToken = jwtUtil.generate(registeredUser.getId(), registeredUser.getRole(), "ACCESS");
            refreshToken = jwtUtil.generate(registeredUser.getId(), registeredUser.getRole(), "REFRESH");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new AuthResponse(accessToken, refreshToken);
    }

}
