package cnpm.nlu.be_empolyy_assessment.dto.request;

import cnpm.nlu.be_empolyy_assessment.entity.CriterionType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CriterionRequest {
    String name;

    CriterionTypeRequest criterionType;

    String description;
    int maxScore;

}
