package yu.likelion14th.be_9th_lab.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import yu.likelion14th.be_9th_lab.domains.user.entity.User;
import yu.likelion14th.be_9th_lab.domains.user.service.UserService;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userService.readByEmail(email);
        return new CustomUserDetails(user);
    }
}

