package pojo.chain_info;

public enum SeatType {
    一等座("一等座"),二等座("二等座"),站票("站票"),硬卧("硬卧"),软卧("软卧");
    private String type;

    SeatType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
