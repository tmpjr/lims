package me.tmpjr.lims.entity;

import lombok.Data;
import me.tmpjr.lims.user.ApplicationUser;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    protected Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    protected Date updatedAt;

    @CreatedBy
    @JoinColumn(name = "created_by", nullable = true, insertable = true, updatable = false)
    @ManyToOne
    //@Column(name = "created_by")
    protected ApplicationUser createdBy;

    @LastModifiedBy
    @JoinColumn(name = "updated_by", nullable = true, insertable = false, updatable = true)
    @ManyToOne
    //@Column(name = "updated_by")
    protected ApplicationUser updatedBy;
}
