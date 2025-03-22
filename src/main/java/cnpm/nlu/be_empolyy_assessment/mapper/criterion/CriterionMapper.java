package cnpm.nlu.be_empolyy_assessment.mapper.criterion;

import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionRequest;
import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionResponse;
import cnpm.nlu.be_empolyy_assessment.entity.Criterion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses = {CriterionTypeMapper.class})
public interface CriterionMapper {

    CriterionMapper INSTANCE = Mappers.getMapper(CriterionMapper.class);

    Criterion fromRequest(CriterionRequest request);

    CriterionResponse toDTO(Criterion criterion);
}
