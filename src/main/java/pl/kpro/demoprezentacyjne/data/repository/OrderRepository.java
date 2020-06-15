package pl.kpro.demoprezentacyjne.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kpro.demoprezentacyjne.data.entity.Order;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>
{
}
