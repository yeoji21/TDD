package jpabasic.atdd.order;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderServiceTest {
    PendingOrderRepository repository = new PendingOrderRepositoryMemoryImpl();
    private CreateOrderService createOrderService = new CreateOrderServiceImpl(repository);

    @Test
    public void createPendingOrder(){
        //given
        long productId = 1l;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);
        //when
        //then
        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        assertThat(pendingOrder.getId()).isPositive();
    }

}
