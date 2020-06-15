package pl.kpro.demoprezentacyjne.web.payload.request;

import lombok.Data;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Data
public class ProductEditRequest
{
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer inventory;
}
