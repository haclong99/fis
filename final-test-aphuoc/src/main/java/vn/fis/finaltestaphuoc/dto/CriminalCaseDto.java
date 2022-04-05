package vn.fis.finaltestaphuoc.dto;

import lombok.Data;

@Data
public class CriminalCaseDto {
    private Long id;
    private String number;
    private String shortDescription;
    private String detailDescription;
    private String notes;
}
