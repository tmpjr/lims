package me.tmpjr.lims.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.tmpjr.lims.entity.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Valid
@Table(name = "users")
@NoArgsConstructor
public class ApplicationUser extends BaseEntity {
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}
