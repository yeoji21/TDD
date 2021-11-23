package jpabasic.atdd.checkmate.service;

import jpabasic.atdd.checkmate.domain.Goal;
import jpabasic.atdd.checkmate.domain.GoalRepository;
import jpabasic.atdd.checkmate.dto.GoalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class SaveGoalServiceImpl implements SaveGoalService {
    private final GoalRepository goalRepository;

    @Override
    public GoalResponse saveGoal(Goal goal)
    {
        return GoalResponse.of(goalRepository.save(goal));
    }
}
