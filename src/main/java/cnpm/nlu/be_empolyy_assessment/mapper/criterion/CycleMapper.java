package cnpm.nlu.be_empolyy_assessment.mapper.criterion;

import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionRequest;
import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionResponse;
import cnpm.nlu.be_empolyy_assessment.dto.request.CycleRequest;
import cnpm.nlu.be_empolyy_assessment.dto.response.CycleResponse;
import cnpm.nlu.be_empolyy_assessment.entity.Criterion;
import cnpm.nlu.be_empolyy_assessment.entity.Cycle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CriterionMapper.class})
public interface CycleMapper {

    CycleMapper INSTANCE = Mappers.getMapper(CycleMapper.class);
    Cycle fromRequest(CycleRequest request);

    CycleResponse toDTO(Cycle cycle);
    Cycle updateCycle(CycleRequest request,String id);
}
