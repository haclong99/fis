package vn.fis.finaltestaphuoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "storage")
@Data
public class Storage extends AbstractEntity{
    private String name;
    private String location;
    @OneToMany(fetch = FetchType.LAZY, mappedBy="storage", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("storage")
    private List<Evidence> evidenceList = new ArrayList<>();
}
