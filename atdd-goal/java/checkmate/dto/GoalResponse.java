package jpabasic.atdd.checkmate.dto;

import jpabasic.atdd.checkmate.domain.Goal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GoalResponse {
    private long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;

    public static GoalResponse of(Goal savedGoal) {
        GoalResponse response = new GoalResponse();
        response.id = savedGoal.getId();
        response.title = savedGoal.getTitle();
        response.startDate = savedGoal.getStartDate();
        response.endDate = savedGoal.getEndDate();
        return response;
    }
}
