package me.tmpjr.lims.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.tmpjr.lims.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.Valid;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Valid
@Table(name = "users")
public class ApplicationUser extends BaseEntity {
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
