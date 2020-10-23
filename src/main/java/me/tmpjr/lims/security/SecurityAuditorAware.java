package me.tmpjr.lims.security;

import lombok.RequiredArgsConstructor;
import me.tmpjr.lims.user.ApplicationUser;
import me.tmpjr.lims.user.ApplicationUserRepository;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SecurityAuditorAware implements AuditorAware<ApplicationUser> {
    private final ApplicationUserRepository userRepository;

    public Optional<ApplicationUser> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return Optional.empty();
        }

        return Optional.ofNullable((ApplicationUser) userRepository.findByUsername((auth.getName())));
    }
}
