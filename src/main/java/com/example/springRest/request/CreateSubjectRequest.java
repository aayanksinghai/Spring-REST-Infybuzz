package com.example.springRest.request;

public class CreateSubjectRequest {

    private String subjectName;
    private Double marksObtained;

    public CreateSubjectRequest(String subjectName, Double marksObtained) {
        this.subjectName = subjectName;
        this.marksObtained = marksObtained;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(Double marksObtained) {
        this.marksObtained = marksObtained;
    }
}
