package ur.disorderapp.model;

/*
    A singleton class for adding and querying the data in database
*/

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ur.disorderapp.EnumValues.GoalStatus;
import ur.disorderapp.database.DatabaseCursorWrapper;
import ur.disorderapp.database.DatabaseHelper;
import ur.disorderapp.database.Schema;

public class Collection
{

    private int assessmentCounter;

    private static Collection sCollection;
    //private Map<String, Goal> Goal_collection;
    private Map<String, SelfAssessmentData> SelfAssessmentData_collection;
    private Map<String,String> Account_collection;
    private final SQLiteDatabase Database;

    public Collection(Context appContext)//Constructor
    {
        Context appContext1 = appContext.getApplicationContext();
        assessmentCounter = 0;
        //Goal_collection = new HashMap<>();
        SelfAssessmentData_collection = new HashMap<>();
        Account_collection = new HashMap<>();
        Database = new DatabaseHelper(appContext1).getWritableDatabase();

        //Initialize goal table
        this.addGoal(new Goal(0, GoalStatus.UNACTIVATED, "sugar"));
        this.addGoal(new Goal(0, GoalStatus.UNACTIVATED, "sleep"));

    }

    private static ContentValues getContentValues_goal(Goal goal)
    {
        ContentValues values = new ContentValues();

        values.put(Schema.GoalTable.Cols.STATUS, goal.getStatus().toString());
        values.put(Schema.GoalTable.Cols.PROGRESS, goal.getProgress());
        values.put(Schema.GoalTable.Cols.NAME, goal.getName());

        return values;
    }

    private static ContentValues getContentValues_account(String uid, String pw)
    {
        ContentValues values = new ContentValues();

        values.put(Schema.AccountTable.Cols.UID, uid);
        values.put(Schema.AccountTable.Cols.PASSWORD, pw);

        return values;
    }

    private static ContentValues getContentValues_selfMonitoringData
            (SelfAssessmentData data)
    {
        ContentValues values = new ContentValues();

        values.put(Schema.HabitTable.Cols.AMOUNT, data.getAmount());
        values.put(Schema.HabitTable.Cols.DATE, data.getDate().getTime());
        values.put(Schema.HabitTable.Cols.FEELING, data.getFeeling().toString());
        values.put(Schema.HabitTable.Cols.FOOD, data.getFood());
        values.put(Schema.HabitTable.Cols.LOCATION, data.getLocation().toString());
        values.put(Schema.HabitTable.Cols.SITUATION, data.getSituation().toString());
        values.put(Schema.HabitTable.Cols.TIME, data.getTime().toString());

        return values;
    }

    //Adding new data to local database
    public void addGoal(Goal goal)
    {
        ContentValues values = getContentValues_goal(goal);
        Database.insert(Schema.GoalTable.NAME, null, values);
    }
    public void addSelfAssessmentData(SelfAssessmentData data)
    {
        ContentValues values = getContentValues_selfMonitoringData(data);
        Database.insert(Schema.GoalTable.NAME, null, values);
        SelfAssessmentData_collection.put(Integer.toString(assessmentCounter), data);
        assessmentCounter++;
    }

    public void addAccount(String uid, String pw)
    {
        ContentValues values = getContentValues_account(uid,pw);
        Database.insert(Schema.AccountTable.NAME,null,values);
        Account_collection.put(uid,pw);
    }

    //Updating goal status / progress using the name of the goal
    public void updateGoal(Goal goal)
    {
        ContentValues values = getContentValues_goal(goal);
        String name = goal.getName();
        Database.update(Schema.GoalTable.NAME, values,
                Schema.GoalTable.Cols.NAME + "=?", new String[]{name});
    }

    public static Collection get(Context c)
    {
        if(sCollection == null)
        {
            sCollection = new Collection(c);
        }
        return sCollection;
    }

    // Helper Methods for querying data
    private DatabaseCursorWrapper queryGoal(String where, String[] args)
    {
        Cursor cursor = Database.query(Schema.GoalTable.NAME,
                null,where,args,null,
                null,null);

        return new DatabaseCursorWrapper(cursor);
    }
    private DatabaseCursorWrapper querySelfAssessmentData(String where, String[] args)
    {
        Cursor cursor = Database.query(Schema.HabitTable.NAME,
                null,where,args,null,
                null,null);

        return new DatabaseCursorWrapper(cursor);
    }

    // returns the current status of the goal of given name
    public GoalStatus checkStatus(String name)
    {

        GoalStatus status = null;

        try(DatabaseCursorWrapper wrapper = queryGoal("NAME=?", new String[]{name}))
        {
            wrapper.moveToFirst();

            Goal goal = wrapper.getGoal();
            status = goal.getStatus();
            wrapper.moveToNext();

        }

        return status;
    }
    // returns the current progress of the goal of given name
    public int checkProgress(String name)
    {

        int progress = 0;

        try(DatabaseCursorWrapper wrapper = queryGoal("NAME=?", new String[]{name}))
        {
            wrapper.moveToFirst();

            Goal goal = wrapper.getGoal();
            progress = goal.getProgress();
            wrapper.moveToNext();

        }

        return progress;
    }

    //return a full list of SelfAssessmentData records
    public List<SelfAssessmentData> getSelfAssessmentData()
    {
        List<SelfAssessmentData> list = new ArrayList<>(SelfAssessmentData_collection.size());

        try (DatabaseCursorWrapper wrapper = querySelfAssessmentData(null, null)) {
            wrapper.moveToFirst();
            while (!wrapper.isAfterLast())
            {
                SelfAssessmentData data = wrapper.getSelfAssessmentData();
                list.add(data);
                wrapper.moveToNext();
            }
        }
        return list;
    }
}
