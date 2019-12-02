package pojo.order;

public class MealsOrder {
    private String MealsName;
    private Double MealsPrice;

    public MealsOrder() {
    }

    public MealsOrder(String mealsName, Double mealsPrice) {
        MealsName = mealsName;
        MealsPrice = mealsPrice;
    }

    public String getMealsName() {
        return MealsName;
    }

    public void setMealsName(String mealsName) {
        MealsName = mealsName;
    }

    public Double getMealsPrice() {
        return MealsPrice;
    }

    public void setMealsPrice(Double mealsPrice) {
        MealsPrice = mealsPrice;
    }
}
