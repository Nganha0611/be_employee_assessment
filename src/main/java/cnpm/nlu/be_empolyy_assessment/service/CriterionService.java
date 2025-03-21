package cnpm.nlu.be_empolyy_assessment.service;

import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionRequest;
import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionResponse;
import cnpm.nlu.be_empolyy_assessment.entity.Criterion;
import cnpm.nlu.be_empolyy_assessment.mapper.criterion.CriterionMapper;
import cnpm.nlu.be_empolyy_assessment.repository.CriterionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CriterionService {

    CriterionRepository criterionRepository;
    CriterionMapper criterionMapper = CriterionMapper.INSTANCE;

    public CriterionResponse create(CriterionRequest request) {
        Criterion criterion = criterionMapper.fromRequest(request);
        return criterionMapper.toDTO(criterionRepository.save(criterion));
    }

    public CriterionResponse update(String id, CriterionRequest request) {
        Criterion criterion = criterionRepository.findById(id)
                .orElseThrow();

        criterion.setName(request.getName());

        return criterionMapper.toDTO(criterionRepository.save(criterion));
    }

    public void delete(String id) {
        criterionRepository.deleteById(id);
    }

    public CriterionResponse findById(String id) {
        return criterionRepository.findById(id)
                .map(criterionMapper::toDTO)
                .orElseThrow();
    }

    public List<CriterionResponse> findAll(Pageable pageable) {
        var list = criterionRepository.findAll(pageable);

        return list.stream().map(criterionMapper::toDTO).toList();
    }
}
