package me.tmpjr.lims.entity;

import lombok.RequiredArgsConstructor;
import me.tmpjr.lims.security.SecurityAuditorAware;
import me.tmpjr.lims.user.ApplicationUser;
import me.tmpjr.lims.user.ApplicationUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@RequiredArgsConstructor
public class PersistenceConfig {
    private final ApplicationUserRepository userRepository;
    @Bean
    public AuditorAware<ApplicationUser> auditorAware() {
        return new SecurityAuditorAware(userRepository);
    }
}
