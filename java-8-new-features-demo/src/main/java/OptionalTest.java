import java.util.Optional;

public class OptionalTest {

    static class Order {
        private final Customer customer;

        public Order(Customer customer) {
            this.customer = customer;
        }

        public Customer getCustomer() {
            return this.customer;
        }
    }

    static class Customer {
        private final String address;

        public Customer(String address) {
            this.address = address;
        }

        public String getAddress() {
            return this.address;
        }
    }

    public static String getOrderAddress(Order order) {
        if (null == order
                || null == order.getCustomer()
                || null == order.getCustomer().getAddress()) {
            throw new RuntimeException("Invalid Order");
        }
        return order.getCustomer().getAddress();
    }

    public static String getOrderAddressUsingOptional(Order order) {
        return Optional.ofNullable(order)
                .map(Order::getCustomer)
                .map(Customer::getAddress)
                .orElseThrow(() -> new RuntimeException("Invalid Order"));
    }

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello"); // Optional.ofNullable(null);
        if (optional.isPresent()) {
            String message = optional.get();
            System.out.println(message);
        } else {
            System.out.println("message is null");
        }
    }

}
