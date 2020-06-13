package pl.kpro.demoprezentacyjne.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kpro.demoprezentacyjne.data.entity.Role;
import pl.kpro.demoprezentacyjne.data.entity.User;
import pl.kpro.demoprezentacyjne.data.repository.RoleRepository;
import pl.kpro.demoprezentacyjne.data.repository.UserRepository;
import pl.kpro.demoprezentacyjne.web.payload.request.UserRegistrationRequest;

import java.util.Set;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Service
public class UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User registerUser(UserRegistrationRequest request)
    {
        User user = new User();
        user.setBanned(false);
        user.setEmail(request.getEmail());
        String enc = passwordEncoder.encode(request.getPassword());
        user.setPassword(enc);
        Role defaultRole = roleRepository.getOneByNameEquals("ROLE_USER").orElseGet(()->{
            Role role = new Role();
            role.setName("ROLE_USER");
            return role;
        });
        Set<Role> roles = Set.of(defaultRole);
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
