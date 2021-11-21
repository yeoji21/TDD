package jpabasic.atdd.order;

import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;


@Repository
class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {

    private AtomicLong atomicId = new AtomicLong(1);

    @Override
    public PendingOrder save(PendingOrder pendingOrder) {
        pendingOrder.assignId(nextId());
        return pendingOrder;
    }

    private long nextId() {
        return atomicId.getAndIncrement();
    }
}
