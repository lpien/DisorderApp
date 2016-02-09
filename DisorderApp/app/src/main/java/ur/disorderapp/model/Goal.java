package ur.disorderapp.model;


public class Goal
{
    private int progress;//the percentage of the progress
    private GoalStatus status;

    public Goal(int progress, GoalStatus status)
    {
        this.progress = progress;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "progress=" + progress +
                ", status=" + status +
                '}';
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public GoalStatus getStatus() {
        return status;
    }

    public void setStatus(GoalStatus status) {
        this.status = status;
    }
}
