public class OnlineCoachingPlan extends MembershipPlan implements RemoteAccess{

    private int videoConsultantions;
    private boolean mealPlanIncluded;
    private boolean recordedLibraryAccess;

    public OnlineCoachingPlan(String planCode, String clientName, int months,
                              double baseMonthlyFee, boolean autoRenew,
                              int videoConsultantions, boolean mealPlanIncluded,
                              boolean recordedLibraryAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.videoConsultantions = videoConsultantions;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;
    }

    @Override
    public String getPlanType(){
        return "Online Coaching";
    }

    @Override
    public double calculateMonthlyNetPrice(){
        double price = getBaseMonthlyFee();

        price += videoConsultantions * 45;

        if (mealPlanIncluded) price += 60;
        if (recordedLibraryAccess) price += 20;
        if (isAutoRenew()) price -= 12;

        return price;
    }

    @Override
    public boolean hasOnlineAccess(){
        return true;
    }

    @Override
    public String toString(){
        return.super.toString() +
                ", Video: " + videoConsultantions +
                ", Meal Plan: " + mealPlanIncluded +
                "' Library: " + recordedLibraryAccess;
    }
}
