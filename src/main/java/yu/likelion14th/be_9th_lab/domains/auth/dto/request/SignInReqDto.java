package yu.likelion14th.be_9th_lab.domains.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInReqDto {
    private String email;
    private String password;
}
