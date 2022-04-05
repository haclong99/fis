package vn.fis.finaltestaphuoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "detective")
@Data
public class Detective extends AbstractEntity{
    private String badgeNumber;
    private Boolean armed;
    @Enumerated(EnumType.STRING)
    private Rank ranking;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="detective", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("detective")
    private List<TrackEntry> trackEntryList = new ArrayList<>();

    @ManyToMany(mappedBy = "detectiveSet", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("detectiveSet")
    private Set<CriminalCase> criminalCaseSet = new HashSet<>() ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;
}
