package eu.lundegaard.jarda.reportcenter.domain;


import eu.lundegaard.jarda.reportcenter.enums.ReportType;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private ReportType type;
    private String tag;
    private int policyNumber;
    private String name;
    private String sureName;
    private String message;

    public  Report(){
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ReportType getType() {
        return type;
    }

    public void setType(ReportType type) {
        this.type = type;
    }
}
