package cnpm.nlu.be_empolyy_assessment.dto.request;

import cnpm.nlu.be_empolyy_assessment.entity.Criterion;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CycleRequest {
    String name;
    LocalDate startDate;
    LocalDate endDate;
    boolean visible;
    Set<Criterion> criteria;
    String description;

}
