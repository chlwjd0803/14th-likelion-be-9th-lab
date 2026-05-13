package yu.likelion14th.be_9th_lab.domains.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yu.likelion14th.be_9th_lab.domains.auth.dto.request.SignInReqDto;
import yu.likelion14th.be_9th_lab.domains.auth.dto.request.SignUpReqDto;
import yu.likelion14th.be_9th_lab.domains.auth.dto.response.SignInResDto;
import yu.likelion14th.be_9th_lab.domains.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInReqDto request) {
        SignInResDto response = authService.signIn(request);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpReqDto request) {
        authService.signUp(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
