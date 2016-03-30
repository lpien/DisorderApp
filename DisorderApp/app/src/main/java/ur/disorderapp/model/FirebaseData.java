package ur.disorderapp.model;

/**
 * Created by shuyangliu on 3/29/16.
 */
public class FirebaseData
{
    SelfAssessmentData mainBody;
    String phoneNumber;

    public FirebaseData(SelfAssessmentData mainBody, String phoneNumber) {
        this.mainBody = mainBody;
        this.phoneNumber = phoneNumber;
    }

    public SelfAssessmentData getMainBody() {
        return mainBody;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
