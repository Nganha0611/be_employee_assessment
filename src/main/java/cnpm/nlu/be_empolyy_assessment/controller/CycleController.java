package cnpm.nlu.be_empolyy_assessment.controller;

import cnpm.nlu.be_empolyy_assessment.dto.ApiResponse;
import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionRequest;
import cnpm.nlu.be_empolyy_assessment.dto.request.CriterionResponse;
import cnpm.nlu.be_empolyy_assessment.dto.request.CycleRequest;
import cnpm.nlu.be_empolyy_assessment.dto.response.CycleResponse;
import cnpm.nlu.be_empolyy_assessment.repository.CycleRepository;
import cnpm.nlu.be_empolyy_assessment.service.CycleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cycle")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CycleController {
    CycleService cycleService;


    // create
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CycleResponse>> create(
            @RequestBody CycleRequest request
    ) {
        return ResponseEntity.ok(ApiResponse.<CycleResponse>builder()
                .data(cycleService.create(request))
                .build());
    }
    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<CycleResponse>> update(
            @RequestBody CycleRequest request,
            @PathVariable String id
    ) {
        return ResponseEntity.ok(ApiResponse.<CycleResponse>builder()
                .data(cycleService.update(id,request))
                .build());
    }
    // get
    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<CycleResponse>>> getAll() {
        List<CycleResponse> data = cycleService.getAll();

        return ResponseEntity.ok(ApiResponse.<List<CycleResponse>>builder()
                .code(200) // Đảm bảo có mã phản hồi
                .message("Success") // Thêm thông báo nếu cần
                .data(data)
                .build());
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CycleResponse>> getById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(ApiResponse.<CycleResponse>builder()
                .data(cycleService.getOne(id))
                .build());
    }
}
