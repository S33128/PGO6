public class GymMembershipPlan extends MembershipPlan implements Freezable{
    private int entiresPerMonth;
    private boolean saunaAccess;

    public GymMembershipPlan(String planCode, String clientName, int months,
                             double baseMonthlyFee, boolean autoRenew,
                             int entiresPerMonth, boolean saunaAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.entiresPerMonth = entiresPerMonth;
        this.saunaAccess = saunaAccess;
    }

    @Override
    public String getPlanType(){
        return "Gym";
    }

    @Override
    public double calculateMonthlyNetPrice(){
        double price = getBaseMonthlyFee();

        price += entiresPerMonth * 4;

        if (saunaAccess) price += 25;
        if (isAutoRenew()) price -= 10;

        return price;
    }

    @Override
    public boolean canFreeze(){
        return getMonths() >= 3;
    }

    @Override
    public String toString(){
        return super.toString() +
                ", Entries: " + entiresPerMonth +
                ", Sauna: " + saunaAccess;
    }
}
