package ur.disorderapp.model;

import java.text.SimpleDateFormat;
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



    private String mDate;

    private String mSent;//a boolean indicating if the data is sent
    private int mSignaled;//indicating if this is a signaled data

    public SelfAssessmentData(String food, int amount,
                              TimePeriod time, Location location,
                              Situation situation, Feeling feeling, int signal)
    {
        mFood = food;
        mAmount = amount;
        mTime = time;
        mLocation = location;
        mSituation = situation;
        mFeeling = feeling;
        mDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        mSent = "0";
        mSignaled = signal;
    }

    @Override
    public String toString() {
        return "SelfAssessmentData{" +"\n"+
                "mFood='" + mFood + '\'' +"\n"+
                ", mAmount=" + mAmount +"\n"+
                ", mTime=" + mTime +"\n"+
                ", mLocation=" + mLocation +"\n"+
                ", mSituation=" + mSituation +"\n"+
                ", mFeeling=" + mFeeling +"\n"+
                ", mDate='" + mDate + '\'' +"\n"+
                ", mSent=" + mSent +"\n"+
                ", mSignaled=" + mSignaled +"\n"+
                '}'+ "\n";
    }
    public int isSignaled()
    {
        return  mSignaled;
    }

    public String isSent()
    {
        return mSent;
    }

    public void setSent(String s)//set mSent to true
    {
        mSent = s;
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

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
