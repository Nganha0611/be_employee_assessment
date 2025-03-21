package cnpm.nlu.be_empolyy_assessment.service;

import cnpm.nlu.be_empolyy_assessment.dto.request.CycleRequest;
import cnpm.nlu.be_empolyy_assessment.dto.response.CriterionTypeDTO;
import cnpm.nlu.be_empolyy_assessment.dto.response.CycleResponse;
import cnpm.nlu.be_empolyy_assessment.entity.Cycle;
import cnpm.nlu.be_empolyy_assessment.mapper.criterion.CycleMapper;
import cnpm.nlu.be_empolyy_assessment.repository.CycleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CycleService {
    CycleRepository cycleRepository;
    CycleMapper cycleMapper = CycleMapper.INSTANCE;
    // crud
    // method to create, getOne,getALL, update, delete cycles
    public CycleResponse create(CycleRequest request){
        log.info(request.toString());
        return cycleMapper.toDTO(cycleRepository.save(cycleMapper.fromRequest(request)));
    }
    public CycleResponse getOne(String id){
        return cycleMapper.toDTO(cycleRepository.findById(id).orElse(null));
    }
    public List<CycleResponse> getAll() {
        List<Cycle> list = Optional.ofNullable(cycleRepository.findAll()).orElse(Collections.emptyList());
        log.info("Fetched Cycles: {}", list);
        return list.stream().map(cycleMapper::toDTO).toList();
    }
    public CycleResponse update(String id, CycleRequest request){
        Optional<Cycle> cycle = cycleRepository.findById(id);
        Cycle newCycle ;
        if(cycle.get().isVisible()){
            newCycle = cycleMapper.updateCycle(request,id);
        }else{
            return null;
        }
        return cycleMapper.toDTO(newCycle);
    }

    public void delete(String id){
        cycleRepository.deleteById(id);
    }
}
