package vn.fis.finaltestaphuoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "track_entry")
@Data
public class TrackEntry extends AbstractEntity{
    private LocalDateTime date;
    private String reason;
    @Enumerated(EnumType.STRING)
    private TrackAction action;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "evidence_id",referencedColumnName="id")
    @JsonIgnoreProperties("trackEntryList")
    private Evidence evidence;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "detective_id",referencedColumnName="id")
    @JsonIgnoreProperties("trackEntryList")
    private Detective detective;
}
