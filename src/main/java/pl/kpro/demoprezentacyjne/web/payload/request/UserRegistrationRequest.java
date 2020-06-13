package pl.kpro.demoprezentacyjne.web.payload.request;

import lombok.Data;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Data
public class UserRegistrationRequest
{
    private String email;
    private String password;
    private String repeatPassword;
}
