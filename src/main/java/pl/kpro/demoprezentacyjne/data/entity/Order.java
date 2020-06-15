package pl.kpro.demoprezentacyjne.data.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Entity(name="orders")
@Data
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private OffsetDateTime creationDate;

    private String address;

    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String zipCode;

    private String phoneNumber;

    @Email
    private String email;

    @ManyToOne(optional=false)
    @JoinColumn(name="product_id")
    private Product product;
}
