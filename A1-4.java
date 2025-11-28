import java.util.List;
import java.util.Date;

/**
 * 客户类
 */
public class Customer {
    private String name;           // 客户姓名
    private String contact;        // 联系方式（电话/邮箱）
    private String deliveryAddress;// 配送地址
    private boolean active;        // 是否为活跃客户
    private List<Order> orders;    // 所有订单

    public Customer(String name, String contact, String deliveryAddress, boolean active, List<Order> orders) {
        this.name = name;
        this.contact = contact;
        this.deliveryAddress = deliveryAddress;
        this.active = active;
        this.orders = orders;
    }
}

/**
 * 订单类
 */
public class Order {
    private Date createDate;       // 订单创建日期
    private String status;         // 订单状态（CREATE/PAID/SHIPPED/DELIVERED）
    private List<OrderDetail> orderDetails; // 订单详情列表
    private Payment payment;       // 支付方式（关联1个Payment子类）

    public Order(Date createDate, String status, List<OrderDetail> orderDetails, Payment payment) {
        this.createDate = createDate;
        this.status = status;
        this.orderDetails = orderDetails;
        this.payment = payment;
    }
}

/**
 * 订单详情类
 */
public class OrderDetail {
    private int quantity;          // 商品数量
    private Product product;       // 关联的商品

    /**
     * 计算该详情的小计金额
     * @return 小计金额（商品单价 * 数量）
     */
    public double calculateSubTotal() {
        return product.getPriceForQuantity(quantity);
    }

    /**
     * 计算该详情的商品总重量
     * @return 总重量（商品单重 * 数量）
     */
    public double calculateWeight() {
        return product.getWeight() * quantity;
    }

    public OrderDetail(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}

/**
 * 商品类
 */
public class Product {
    private String title;          // 商品标题
    private double weight;         // 商品单重（单位：kg）
    private String description;    // 商品描述
    private double unitPrice;      // 商品单价（补充属性，用于计算金额）

    /**
     * 根据数量获取总价
     * @param quantity 数量
     * @return 总价
     */
    public double getPriceForQuantity(int quantity) {
        return unitPrice * quantity;
    }

    public double getWeight() {
        return weight;
    }

    public Product(String title, double weight, String description, double unitPrice) {
        this.title = title;
        this.weight = weight;
        this.description = description;
        this.unitPrice = unitPrice;
    }
}

/**
 * 支付抽象类（父类）
 */
public abstract class Payment {
    protected double amount; // 支付金额

    public Payment(double amount) {
        this.amount = amount;
    }
}

/**
 * 信用卡支付（子类）
 */
public class Credit extends Payment {
    private String number;       // 信用卡号
    private String type;         // 卡类型（Visa/Mastercard）
    private Date expireDate;     // 过期日期

    public Credit(double amount, String number, String type, Date expireDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expireDate = expireDate;
    }
}

/**
 * 现金支付（子类）
 */
public class Cash extends Payment {
    private double cashTendered; // 支付金额（可能多于应付金额，需找零）

    public Cash(double amount, double cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }
}

/**
 * 银行转账（子类）
 */
public class WireTransfer extends Payment {
    private String bankID;       // 银行ID
    private String bankName;     // 银行名称

    public WireTransfer(double amount, String bankID, String bankName) {
        super(amount);
        this.bankID = bankID;
        this.bankName = bankName;
    }
}

/**
 * 支付宝支付（子类）
 */
public class AliPay extends Payment {
    private String number;       // 支付宝账号（手机号/邮箱）

    public AliPay(double amount, String number) {
        super(amount);
        this.number = number;
    }
}

/**
 * 微信支付（子类）
 */
public class WeixinPay extends Payment {
    private String number;       // 微信账号（手机号/微信号）

    public WeixinPay(double amount, String number) {
        super(amount);
        this.number = number;
    }
}