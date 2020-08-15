package me.tmpjr.lims.container;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.tmpjr.lims.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "containers")
@Entity
@Valid
public class Container extends BaseEntity {
    @NotBlank(message = "Container name is required.")
    private String containerName;

}
