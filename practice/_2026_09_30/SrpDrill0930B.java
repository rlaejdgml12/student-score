package _2026_09_30;

public class SrpDrill0930B {

    // ===== 셋업 (연습 대상이 아닙니다. 그대로 사용하세요) =====
    record CancelRequest(long orderId) {}

    record Order(long id, String status) {
        static Order canceledOf(long orderId) {
            return new Order(orderId, "CANCELED");
        }
    }

    interface OrderRepository  { void save(Order order); }
    interface RefundSender     { void refund(Order order); }
    interface CancelNotifier   { void notifyCanceled(Order order); }

    class OrderCancelService{
        private final OrderRepository repository;
        private final RefundSender sender;
        private final CancelNotifier cancel;

        OrderCancelService(OrderRepository repository, RefundSender sender, CancelNotifier cancel){
            this.repository = repository;
            this.sender = sender;
            this.cancel = cancel;
        }

        void register(CancelRequest request){
            Order order = Order.canceledOf(request.orderId());
            repository.save(order);
            sender.refund(order);
            cancel.notifyCanceled(order);
        }
    }


    public static void main(String[] args) {

    }
}
