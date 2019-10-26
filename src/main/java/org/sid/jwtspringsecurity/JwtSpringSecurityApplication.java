package org.sid.jwtspringsecurity;

import org.sid.jwtspringsecurity.dao.TaskRepository;
import org.sid.jwtspringsecurity.entities.AppUser;
import org.sid.jwtspringsecurity.entities.Role;
import org.sid.jwtspringsecurity.entities.Task;
import org.sid.jwtspringsecurity.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class   JwtSpringSecurityApplication implements CommandLineRunner {
    @Autowired
      private TaskRepository taskRepository;
    @Autowired
    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(JwtSpringSecurityApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public void run(String... args) throws Exception {
        accountService.saveUser(new AppUser("admin","1234",null));
        accountService.saveUser(new AppUser("user","1234",null));
        accountService.saveRole(new Role(null,"ADMIN"));
        accountService.saveRole(new Role(null,"USER"));
        accountService.addRoleToUser("admin","USER");
        accountService.addRoleToUser("admin","ADMIN");
        accountService.addRoleToUser("user","USER");

        Stream.of("T1","T2","T3").forEach(t->{
             taskRepository.save(new Task(null,t));
        } );
        taskRepository.findAll().forEach(t->{
            System.out.println(t.getName() );
        });
    }
}
