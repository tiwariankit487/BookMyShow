package com.scaler.bookmyshowjune2023.models;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass //don't create a seperate table of this.
@EntityListeners({AuditingEntityListener.class})
public class BaseModel {
    @Id
    private long id;
}
