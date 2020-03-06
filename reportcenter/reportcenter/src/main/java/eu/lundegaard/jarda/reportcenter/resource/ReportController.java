package eu.lundegaard.jarda.reportcenter.resource;

import eu.lundegaard.jarda.reportcenter.model.ReportRequestDto;
import eu.lundegaard.jarda.reportcenter.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/report")
    public ResponseEntity getAllReports(){
        return ResponseEntity.ok(reportService.getModelMapOfAllReports());
    }

    @PostMapping("/report")
    public ResponseEntity createNewReport(@RequestBody ReportRequestDto reportData){
        Object dto = reportService.createAndReturnReport(reportData);
        if (dto == null) {
            return ResponseEntity.status(400).body(reportService.error);
        }
        return ResponseEntity.status(200).body(reportService.error);
    }
}
