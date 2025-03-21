package cnpm.nlu.be_empolyy_assessment.controller;

import cnpm.nlu.be_empolyy_assessment.dto.ApiResponse;
import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionTypeRequest;
import cnpm.nlu.be_empolyy_assessment.dto.response.CriterionTypeDTO;
import cnpm.nlu.be_empolyy_assessment.service.CriterionTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criterion-type")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CriterionTypeController {

    CriterionTypeService criterionTypeService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CriterionTypeDTO>> create(
            @RequestBody CriterionTypeRequest request
    ) {
        return ResponseEntity.ok(ApiResponse.<CriterionTypeDTO>builder()
                .message("Da tao loai tieu chi thanh cong")
                .data(criterionTypeService.create(request))
                .build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<CriterionTypeDTO>> update(
            @PathVariable("id") String id, @RequestBody CriterionTypeRequest request
    ) {
        return ResponseEntity.ok(ApiResponse.<CriterionTypeDTO>builder()
                .message("Da cap nhat loai tieu chi thanh cong")
                .data(criterionTypeService.update(id, request))
                .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable("id") String id
    ) {
        criterionTypeService.delete(id);
        return ResponseEntity.ok(ApiResponse.<CriterionTypeDTO>builder()
                .message("Da xoa loai tieu chi thanh cong")
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CriterionTypeDTO>> findById(
            @PathVariable("id") String id
    ) {
        return ResponseEntity.ok(ApiResponse.<CriterionTypeDTO>builder()
                .data(criterionTypeService.findById(id))
                .build());
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<CriterionTypeDTO>>> findAll(
            @PageableDefault Pageable pageable
    ) {
        return ResponseEntity.ok(ApiResponse.<List<CriterionTypeDTO>>builder()
                .data(criterionTypeService.findAll(pageable))
                .build());
    }
}
