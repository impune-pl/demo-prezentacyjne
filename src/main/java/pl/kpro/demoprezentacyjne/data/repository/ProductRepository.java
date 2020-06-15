package pl.kpro.demoprezentacyjne.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kpro.demoprezentacyjne.data.entity.Product;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>
{
}
