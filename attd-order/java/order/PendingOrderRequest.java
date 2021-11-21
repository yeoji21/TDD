package jpabasic.atdd.order;

import lombok.Getter;

@Getter
public class PendingOrderRequest {
    private long productId;
    private int quantity;

    public static PendingOrderRequest of(long productId, int quantity) {
        PendingOrderRequest pendingOrderRequest = new PendingOrderRequest();
        pendingOrderRequest.productId = productId;
        pendingOrderRequest.quantity = quantity;
        return pendingOrderRequest;
    }
}
