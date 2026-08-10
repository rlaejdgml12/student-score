package _2026_08_10;

public class Order {


    static class OrderSummary{

        private final int totalPrice;

        public OrderSummary(int totalPrice){
            this.totalPrice = totalPrice;
        }

        public int getTotalPrice(){
            return totalPrice;
        }

    }
}
