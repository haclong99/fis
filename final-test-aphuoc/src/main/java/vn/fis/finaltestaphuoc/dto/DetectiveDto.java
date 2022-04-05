package vn.fis.finaltestaphuoc.dto;

import lombok.Data;
import vn.fis.finaltestaphuoc.entity.EmploymentStatus;
import vn.fis.finaltestaphuoc.entity.Rank;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class DetectiveDto {
    private Long id;
    private String badgeNumber;
    private Boolean armed;
    @Enumerated(EnumType.STRING)
    private Rank ranking;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;
}
