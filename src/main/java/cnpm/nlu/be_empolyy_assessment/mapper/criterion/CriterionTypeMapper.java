package cnpm.nlu.be_empolyy_assessment.mapper.criterion;

import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionTypeRequest;
import cnpm.nlu.be_empolyy_assessment.dto.response.CriterionTypeDTO;
import cnpm.nlu.be_empolyy_assessment.entity.CriterionType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CriterionTypeMapper {

    CriterionTypeMapper INSTANCE = Mappers.getMapper(CriterionTypeMapper.class);

    CriterionType fromRequest(CriterionTypeRequest request);
    CriterionTypeDTO toDTO(CriterionType criterionType);
}