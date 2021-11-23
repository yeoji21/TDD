package jpabasic.atdd.checkmate.service;

import jpabasic.atdd.checkmate.domain.Goal;
import jpabasic.atdd.checkmate.dto.GoalResponse;

public interface SaveGoalService {
    GoalResponse saveGoal(Goal goal);
}
