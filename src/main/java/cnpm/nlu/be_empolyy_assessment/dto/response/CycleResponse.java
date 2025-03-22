package cnpm.nlu.be_empolyy_assessment.dto.response;

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
public class CycleResponse {
    String id;
    String name;
    LocalDate startDate;
    LocalDate endDate;
    boolean visible;
    String description;
    Set<Criterion> criteria;

}
