package pojo.chain_info;

public enum SeatType {
    一等座("一等座", 200), 二等座("二等座", 330), 站票("站票", 200), 硬卧("硬卧", 100), 软卧("软卧", 100);
    private String type;
    private int numOfType;

    SeatType(String type, int numOfType) {
        this.type = type;
        this.numOfType = numOfType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
