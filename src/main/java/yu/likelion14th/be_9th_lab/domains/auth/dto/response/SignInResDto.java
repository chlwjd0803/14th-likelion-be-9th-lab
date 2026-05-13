package yu.likelion14th.be_9th_lab.domains.auth.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInResDto {
    private String accessToken;
    private String refreshToken;
}
