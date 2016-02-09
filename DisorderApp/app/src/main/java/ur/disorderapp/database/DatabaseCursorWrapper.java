package ur.disorderapp.database;


import android.database.Cursor;
import android.database.CursorWrapper;

import ur.disorderapp.model.Goal;
import ur.disorderapp.model.GoalStatus;

public class DatabaseCursorWrapper extends CursorWrapper
{
    public DatabaseCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public Goal getGoal()
    {
        int progress = getInt(getColumnIndex(Schema.GoalTable.Cols.PROGRESS));
        GoalStatus status = GoalStatus.valueOf(
                getString(
                        getColumnIndex(
                                Schema.GoalTable.Cols.STATUS)));

        Goal goal = new Goal(progress, status);
        return goal;
    }



}
