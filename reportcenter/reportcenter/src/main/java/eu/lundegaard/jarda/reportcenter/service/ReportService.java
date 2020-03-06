package eu.lundegaard.jarda.reportcenter.service;

import eu.lundegaard.jarda.reportcenter.domain.Report;
import eu.lundegaard.jarda.reportcenter.model.ReportRequestDto;
import eu.lundegaard.jarda.reportcenter.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;
    public String error = "";

    public void saveReport(Report report){
        reportRepository.save(report);
    }

    public Iterable<Report> getAllReports(){
        return reportRepository.findReportByIdIsNotNull();
    }

    public ModelMap getModelMapOfAllReports(){
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("Reports", getAllReports());
        return modelMap;
    }

    public Report createAndReturnReport(ReportRequestDto reportData){
        error = "Report saved";
        if (!isNameLetters(reportData)){
            error = "Wrong name";
        }else if (!isSurenameLetters(reportData)){
            error = "Wrong surename";
        }else if (!isPolicynumberDigits(reportData)){
            error = "Wrong policy number";
        }else {
            Report newReport = new Report();
            newReport.setTag(reportData.getTag());
            newReport.setPolicyNumber(Integer.parseInt(reportData.getPolicyNumber()));
            newReport.setName(reportData.getName());
            newReport.setSureName(reportData.getSurename());
            newReport.setType(reportData.getType());
            newReport.setMessage(reportData.getMessage());
            saveReport(newReport);
            return newReport;
        }return null;
    }

    public boolean isNameLetters(ReportRequestDto reportData){
        for (char c : reportData.getName().toCharArray()) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }return true;
    }

    public boolean isSurenameLetters(ReportRequestDto reportData){
        for (char c : reportData.getSurename().toCharArray()) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }return true;
    }

    public boolean isPolicynumberDigits(ReportRequestDto reportData){
        try {
            Integer.parseInt(reportData.getPolicyNumber());
        }catch (NumberFormatException e) {
            return false;
        }return true;
    }
}
