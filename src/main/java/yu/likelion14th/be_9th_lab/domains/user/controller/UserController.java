package yu.likelion14th.be_9th_lab.domains.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yu.likelion14th.be_9th_lab.domains.user.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserInfo(@PathVariable(value = "userId") Long userId) {
        return ResponseEntity.ok().body(userService.readById(userId));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal Long userId) {
        // 굳이 이메일로 다시 찾을 필요 없이, 인증된 userId로 바로 사용자를 조회합니다.
        return ResponseEntity.ok().body(userService.readById(userId));
    }
}
