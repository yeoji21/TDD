package jpabasic.atdd.checkmate.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GoalRequest {
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
}
