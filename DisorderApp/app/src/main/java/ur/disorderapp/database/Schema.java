package ur.disorderapp.database;

public class Schema
{

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "goal_database.db";

    public Schema()
    {
        /*
         *  To prevent someone from accidentally instantiating the contract class,
         *  give it an empty constructor.
         */
    }

    public static final class  GoalTable
    {
        public static final String NAME = "goals";

        public static final class Cols
        {
            public static final String STATUS = "status";
            public static final String PROGRESS = "progress";
        }
    }
}
