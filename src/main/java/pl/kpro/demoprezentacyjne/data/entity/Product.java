package pl.kpro.demoprezentacyjne.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Entity
@Data
@NoArgsConstructor
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(precision=10, scale=2)
    private Double price;

    @PositiveOrZero
    private Integer inventory;

    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY)
    private Set<Order> orders;
}
