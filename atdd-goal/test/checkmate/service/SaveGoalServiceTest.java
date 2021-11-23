package jpabasic.atdd.checkmate.service;

import jpabasic.atdd.checkmate.domain.Goal;
import jpabasic.atdd.checkmate.domain.GoalRepository;
import jpabasic.atdd.checkmate.dto.GoalRequest;
import jpabasic.atdd.checkmate.dto.GoalResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

//import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveGoalServiceTest {

    @Mock
    private GoalRepository goalRepository;
    @InjectMocks
    private SaveGoalServiceImpl saveService;

    @Test
    public void saveGoal(){
        //given
        GoalRequest goalRequest = GoalRequest.of("자바의 정석 스터디", LocalDate.of(2021, 11, 23),
                LocalDate.of(2021, 12, 31));
        Goal goal = Goal.of(goalRequest);
        when(goalRepository.save(goal)).thenReturn(Goal.of(1L, goalRequest));

        //when
        GoalResponse response = saveService.saveGoal(goal);
        //then
        assertThat(response.getId()).isGreaterThan(0L);
    }
}