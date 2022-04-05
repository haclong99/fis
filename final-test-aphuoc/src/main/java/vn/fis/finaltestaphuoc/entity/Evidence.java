package vn.fis.finaltestaphuoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "evidence")
@Data
public class Evidence extends AbstractEntity{
    private String number;
    private String itemName;
    private String notes;
    private Boolean archived;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "storage_id",referencedColumnName="id")
    @JsonIgnoreProperties("evidenceList")
    private Storage storage;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "case_id",referencedColumnName="id")
    @JsonIgnoreProperties("evidenceList")
    private CriminalCase criminalCase;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="evidence", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("evidence")
    private List<TrackEntry> trackEntryList = new ArrayList<>();
}
