package eu.lundegaard.jarda.reportcenter.repository;

import eu.lundegaard.jarda.reportcenter.domain.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
    List<Report> findReportByIdIsNotNull();
}
