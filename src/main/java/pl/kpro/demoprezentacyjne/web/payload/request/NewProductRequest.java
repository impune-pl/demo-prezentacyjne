package pl.kpro.demoprezentacyjne.web.payload.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Data
public class NewProductRequest
{
    private String name;

    private String description;

    private Double price;

    private Integer inventory;
}
