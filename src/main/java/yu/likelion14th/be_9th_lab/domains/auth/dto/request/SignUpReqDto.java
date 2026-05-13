package yu.likelion14th.be_9th_lab.domains.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import yu.likelion14th.be_9th_lab.domains.user.entity.User;

@Getter
@AllArgsConstructor
public class SignUpReqDto {
    private String email;
    private String password;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
