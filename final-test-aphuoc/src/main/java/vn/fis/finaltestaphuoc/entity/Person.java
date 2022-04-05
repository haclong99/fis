package vn.fis.finaltestaphuoc.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person")
@Data
public class Person extends AbstractEntity{
    private String username;
    private String fistName;
    private String lastName;
    private String password;
    private LocalDateTime hiringDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    @JsonManagedReference
    private Detective detective;
}
