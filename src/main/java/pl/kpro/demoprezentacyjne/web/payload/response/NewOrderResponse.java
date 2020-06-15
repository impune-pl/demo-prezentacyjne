package pl.kpro.demoprezentacyjne.web.payload.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Data
public class NewOrderResponse
{
    private String address;
    private String zipCode;
    private String phoneNumber;
    private String email;
    @Setter(AccessLevel.NONE)
    private Long productId;

    public NewOrderResponse(Long id)
    {
        this.productId=id;
    }
}
