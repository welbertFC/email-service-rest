package com.email.emailservicerest.models;

import com.email.emailservicerest.models.enums.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class EmailModel implements Serializable {

    @Id
    private UUID id;

    private String emailFrom;

    private String emailTo;

    private String subject;

    private String text;

    private StatusEmail statusEmail;

    @CreatedDate
    private LocalDateTime createdDate;


    public void generateId() {
        this.id = UUID.randomUUID();
    }

}
