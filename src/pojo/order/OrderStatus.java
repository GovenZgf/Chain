package pojo.order;

public enum OrderStatus {
    未支付("未支付"),已支付("已支付"),已改签("已改签"),已退票("已退款");
    private String status;
    OrderStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
