package pl.kpro.demoprezentacyjne.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kpro.demoprezentacyjne.data.entity.Role;

import java.util.Optional;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>
{
    Optional<Role> getOneByNameEquals(String name);
}
