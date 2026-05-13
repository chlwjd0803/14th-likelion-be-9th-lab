package yu.likelion14th.be_9th_lab.domains.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.likelion14th.be_9th_lab.domains.auth.dto.request.SignInReqDto;
import yu.likelion14th.be_9th_lab.domains.auth.dto.request.SignUpReqDto;
import yu.likelion14th.be_9th_lab.domains.auth.dto.response.SignInResDto;
import yu.likelion14th.be_9th_lab.domains.user.entity.User;
import yu.likelion14th.be_9th_lab.domains.user.service.UserService;
import yu.likelion14th.be_9th_lab.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignInResDto signIn(SignInReqDto signInRequest) {
        String email = signInRequest.getEmail();
        String password = signInRequest.getPassword();

        User user = userService.readByEmail(email);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호가 불일치합니다.");
        }

        String accessToken = jwtUtil.generateAccessToken(user.getId(), user.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(user.getId(), user.getEmail());

        return SignInResDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Transactional
    public void signUp(SignUpReqDto request) {
        if (userService.existsByEmail(request.getEmail())) {
            throw new RuntimeException("이미 존재하는 email 입니다.");
        }

        String encoded = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .email(request.getEmail())
                .password(encoded)
                .build();

        userService.save(user);
    }
}
