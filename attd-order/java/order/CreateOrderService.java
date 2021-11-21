package jpabasic.atdd.order;

public interface CreateOrderService {

    PendingOrder createPendingOrder(PendingOrderRequest request);
}
