package jpabasic.atdd.checkmate.domain;

import jpabasic.atdd.checkmate.dto.GoalRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class Goal {

    @Id @GeneratedValue
    private long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;

    public static Goal of(GoalRequest request) {
        Goal goal = new Goal();
        goal.title = request.getTitle();
        goal.startDate = request.getStartDate();
        goal.endDate = request.getEndDate();
        return goal;
    }

    public static Goal of(long id, GoalRequest request) {
        Goal goal = new Goal();
        goal.id = id;
        goal.title = request.getTitle();
        goal.startDate = request.getStartDate();
        goal.endDate = request.getEndDate();
        return goal;
    }

    public void assignId(long nextId) {
        this.id = nextId;
    }
}
