package cnpm.nlu.be_empolyy_assessment.controller;

import cnpm.nlu.be_empolyy_assessment.dto.ApiResponse;
import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionRequest;
import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionResponse;
import cnpm.nlu.be_empolyy_assessment.service.CriterionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criterion")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CriterionController {

    CriterionService criterionService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CriterionResponse>> create(
            @RequestBody CriterionRequest request
    ) {
        return ResponseEntity.ok(ApiResponse.<CriterionResponse>builder()
                .message("Da tao loai tieu chi thanh cong")
                .data(criterionService.create(request))
                .build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<CriterionResponse>> update(
            @PathVariable("id") String id, @RequestBody CriterionRequest request
    ) {
        return ResponseEntity.ok(ApiResponse.<CriterionResponse>builder()
                .message("Da cap nhat loai tieu chi thanh cong")
                .data(criterionService.update(id, request))
                .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable("id") String id
    ) {
        criterionService.delete(id);
        return ResponseEntity.ok(ApiResponse.<CriterionResponse>builder()
                .message("Da xoa loai tieu chi thanh cong")
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CriterionResponse>> findById(
            @PathVariable("id") String id
    ) {
        return ResponseEntity.ok(ApiResponse.<CriterionResponse>builder()
                .data(criterionService.findById(id))
                .build());
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<CriterionResponse>>> findAll(
            @PageableDefault Pageable pageable
    ) {
        return ResponseEntity.ok(ApiResponse.<List<CriterionResponse>>builder()
                .data(criterionService.findAll(pageable))
                .build());
    }
}
