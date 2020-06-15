package pl.kpro.demoprezentacyjne.web.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Data
@NoArgsConstructor
public class NewOrderRequest
{
    private String address;

    private String zipCode;

    private String phoneNumber;

    private String email;

    private Long productId;
}
