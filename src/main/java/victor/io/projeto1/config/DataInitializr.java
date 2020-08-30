package victor.io.projeto1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import victor.io.projeto1.entity.User;
import victor.io.projeto1.repository.UserRepository;

import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            createUser("Victor Cesar Miranda", "victorcesarmiranda@gmail.com");
            createUser("Maria Julia", "maju@gmail.com");
            createUser("Sadi Antônio", "sadi@gmail.com");
        }
        User user = userRepository.findByEmailLala("victorcesarmiranda@gmail.com");
        System.out.println(user.getName());

    }

    public void createUser (String name, String email) {
        User user = new User(name, email);
        userRepository.save(user);
    }
}
