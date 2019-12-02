package pojo.order;

public enum OrderStatus {
    未支付("未支付"),已支付("已支付"),正在退票("正在退票"),已退票("已退票");
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
