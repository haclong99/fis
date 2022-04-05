package vn.fis.finaltestaphuoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "criminal_case")
@Data
public class CriminalCase extends AbstractEntity{
    private String number;
    private String shortDescription;
    private String detailDescription;
    private String notes;
    @Enumerated(EnumType.STRING)
    private CaseType type;
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    @OneToMany(fetch = FetchType.LAZY, mappedBy="criminalCase", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("criminalCase")
    private List<Evidence> evidenceList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "working_detective_case", joinColumns = @JoinColumn(name = "case_id"),
            inverseJoinColumns = @JoinColumn(name = "detective_id"))
    private Set<Detective> detectiveSet = new HashSet<>();
}
