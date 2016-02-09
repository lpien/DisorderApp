package ur.disorderapp.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{

    public DatabaseHelper(Context context)
    {
        super(context, Schema.DATABASE_NAME, null, Schema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + Schema.GoalTable.NAME
                + "(_id integer primary key autoincrement, "
                + Schema.GoalTable.Cols.STATUS + ", "
                + Schema.GoalTable.Cols.PROGRESS + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
