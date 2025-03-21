package cnpm.nlu.be_empolyy_assessment.service;

import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionTypeRequest;
import cnpm.nlu.be_empolyy_assessment.dto.response.CriterionTypeDTO;
import cnpm.nlu.be_empolyy_assessment.entity.CriterionType;
import cnpm.nlu.be_empolyy_assessment.mapper.criterion.CriterionTypeMapper;
import cnpm.nlu.be_empolyy_assessment.repository.CriterionTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CriterionTypeService {

    CriterionTypeRepository criterionTypeRepository;
    CriterionTypeMapper criterionTypeMapper = CriterionTypeMapper.INSTANCE;

    public CriterionTypeDTO create(CriterionTypeRequest request) {
        CriterionType criterionType = criterionTypeMapper.fromRequest(request);
        return criterionTypeMapper.toDTO(criterionTypeRepository.save(criterionType));
    }

    public CriterionTypeDTO update(String id, CriterionTypeRequest request) {
        CriterionType criterionType = criterionTypeRepository.findById(id)
                .orElseThrow();

        criterionType.setName(request.getName());

        return criterionTypeMapper.toDTO(criterionTypeRepository.save(criterionType));
    }

    public void delete(String id) {
        criterionTypeRepository.deleteById(id);
    }

    public CriterionTypeDTO findById(String id) {
        return criterionTypeRepository.findById(id)
                .map(criterionTypeMapper::toDTO)
                .orElseThrow();
    }

    public List<CriterionTypeDTO> findAll(Pageable pageable) {
        var list = criterionTypeRepository.findAll(pageable);

        return list.stream().map(criterionTypeMapper::toDTO).toList();
    }
}
