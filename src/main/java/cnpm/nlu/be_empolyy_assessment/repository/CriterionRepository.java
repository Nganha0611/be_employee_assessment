package cnpm.nlu.be_empolyy_assessment.repository;

import cnpm.nlu.be_empolyy_assessment.entity.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterionRepository extends JpaRepository<Criterion, String> {


}
