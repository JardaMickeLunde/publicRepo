package eu.lundegaard.jarda.reportcenter.model;

import eu.lundegaard.jarda.reportcenter.enums.ReportType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportRequestDto {
    private ReportType type;
    private String name;
    private String surename;
    private String message;
    private String policyNumber;
    private String tag;
}


//{
//        "tag" : "firstReport"
//        "name" : "jarda"
//        "surename" : "micket"
//        "type" : "COMPLAINT"
//        "policyNumber" : "132456"
//        "message" : "tak to snad bude fungovat"
//        }
