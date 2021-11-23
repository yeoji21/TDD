package jpabasic.atdd.checkmate.api;

import jpabasic.atdd.checkmate.domain.Goal;
import jpabasic.atdd.checkmate.dto.GoalRequest;
import jpabasic.atdd.checkmate.dto.GoalResponse;
import jpabasic.atdd.checkmate.service.SaveGoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/goal")
@RestController
public class GoalController {
    private final SaveGoalService goalService;
    
    @PostMapping
    public ResponseEntity<GoalResponse> saveGoal(@RequestBody GoalRequest request) {
        GoalResponse response = goalService.saveGoal(Goal.of(request));
        return ResponseEntity.ok(response);
    }
}
