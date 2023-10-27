package database;

import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;
import org.perscholas.database.entity.dao.OrderDAO;
import org.perscholas.database.entity.dao.OrderDetailDAO;
import org.perscholas.database.entity.dao.ProductsDAO;

import java.util.List;
import java.util.Scanner;

public class CreateOrderDetails {

    private OrderDAO orderDAO = new OrderDAO();
    private ProductsDAO productsDAO = new ProductsDAO();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    public static void main(String[] args) {
        CreateOrderDetails cod = new CreateOrderDetails();
        cod.createOrderDetails();

    }

    private void createOrderDetails() {
//the goal is to insert a record into the order detail table
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a product name to add to your order: ");
        String productName = scanner.nextLine();//Harley
        List<Product> products = productsDAO.findByName(productName);

        if (products.size() == 0){
            System.out.println("You didn't enter a valid product name");
            System.exit(0);
        }

        for (Product product: products) {
            System.out.println("id="+product.getId()+" | "+product.getProductName());
        }
        System.out.print("\nSelect a product id:");//1
        Integer productId = scanner.nextInt();

        Product product = productsDAO.findById(productId);

        System.out.print("\nEnter a order id:");
        Integer enterOrderId = scanner.nextInt();

        Order order = orderDAO.findById(enterOrderId);//10100
        if (order == null) {
            System.out.println("The order with id "+ enterOrderId+ " does not exist" );
            System.exit(0);
        }

        for (OrderDetail orderDetail : order.getOrdersDetail()) {
            if (orderDetail.getProduct().getId()==productId) {
                System.out.println("The product "+ product.getProductName()+ " is already part of the order with id "+ order.getId() +". Can not add again");
                System.exit(0);
            }
        }

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setOrder(order);
        orderDetail.setOrderLineNumber((short)3);
        orderDetail.setQuantityOrdered(12);
        orderDetail.setPriceEach(25.55);
//        orderDetailDAO.save(orderDetail);  /// the same as  order.getOrdersDetail().add(orderDetail); orderDAO.save(order);
        order.getOrdersDetail().add(orderDetail);
        orderDAO.save(order);
        System.out.println("Successfully added product "+ product.getProductName() +" to order with id "+ order.getId());
    }
}
