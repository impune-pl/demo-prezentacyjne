package pl.kpro.demoprezentacyjne.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.kpro.demoprezentacyjne.data.entity.User;
import pl.kpro.demoprezentacyjne.data.repository.UserRepository;

import java.util.Optional;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Component
public class CustomUserDetailsService implements UserDetailsService
{
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> user = userRepository.findUserByEmailEquals(username);
        if(user.isPresent())
        {
            return user.get();
        }
        else
        {
            throw new UsernameNotFoundException("User with email "+username+" does not exist");
        }
    }
}
