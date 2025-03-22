package cnpm.nlu.be_empolyy_assessment.repository;

import cnpm.nlu.be_empolyy_assessment.entity.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, String> {


}
