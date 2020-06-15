package pl.kpro.demoprezentacyjne.web.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kpro.demoprezentacyjne.data.entity.Product;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Data
@NoArgsConstructor
public class ProductEditResponse
{
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer inventory;

    public void setPrice(Double price)
    {
        this.price = Math.round(price *100)/100d;
    }

    public void setInventory(Integer inventory)
    {
        this.inventory = inventory > 0 ? inventory : 0;
    }

    public ProductEditResponse(Product product)
    {
        this.id=product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price=product.getPrice();
        this.inventory = product.getInventory();
    }
}
