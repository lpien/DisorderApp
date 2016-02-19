package ur.disorderapp.model;

import java.util.Date;

import ur.disorderapp.EnumValues.Feeling;
import ur.disorderapp.EnumValues.Location;
import ur.disorderapp.EnumValues.Situation;
import ur.disorderapp.EnumValues.TimePeriod;

public class SelfAssessmentData
{

    private String mFood;
    private int mAmount;
    private TimePeriod mTime;
    private Location mLocation;
    private Situation mSituation;
    private Feeling mFeeling;

    private Date mDate;

    public SelfAssessmentData(String food, int amount,
                              TimePeriod time, Location location,
                              Situation situation, Feeling feeling, Date date)
    {
        mFood = food;
        mAmount = amount;
        mTime = time;
        mLocation = location;
        mSituation = situation;
        mFeeling = feeling;
        mDate = date;
    }

    public String getFood() {
        return mFood;
    }

    public void setFood(String food) {
        mFood = food;
    }

    public int getAmount() {
        return mAmount;
    }

    public void setAmount(int amount) {
        mAmount = amount;
    }

    public TimePeriod getTime() {
        return mTime;
    }

    public void setTime(TimePeriod time) {
        mTime = time;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public Situation getSituation() {
        return mSituation;
    }

    public void setSituation(Situation situation) {
        mSituation = situation;
    }

    public Feeling getFeeling() {
        return mFeeling;
    }

    public void setFeeling(Feeling feeling) {
        mFeeling = feeling;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
