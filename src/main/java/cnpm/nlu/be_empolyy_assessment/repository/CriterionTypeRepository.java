package cnpm.nlu.be_empolyy_assessment.repository;

import cnpm.nlu.be_empolyy_assessment.entity.Criterion;
import cnpm.nlu.be_empolyy_assessment.entity.CriterionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CriterionTypeRepository extends JpaRepository<CriterionType, String> {

    Optional<CriterionType> findByName(String name);
}
