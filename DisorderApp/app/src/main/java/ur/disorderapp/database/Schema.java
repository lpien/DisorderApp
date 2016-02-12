package ur.disorderapp.database;

public class Schema
{

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "database.db";

    public Schema()
    {
        /*
         *  To prevent someone from accidentally instantiating the contract class,
         *  give it an empty constructor.
         */
    }
    //A table keep track of the user's progress
    public static final class  GoalTable
    {
        public static final String NAME = "goals";

        public static final class Cols
        {
            public static final String STATUS = "status";

            public static final String PROGRESS = "progress";
        }
    }
    //A table record the user's living habits taken from their self-monitoring results
    public static final class HabitTable
    {
        public static  final String NAME = "habit";

        public static final class Cols
        {
            //Regarding to the question "Which of these did you eat?"
            public static final String FOOD = "food";

            //Regarding to the Question "How many?"
            public static final String AMOUNT = "amount";

            //Regarding to the Question "When?"
            public static final String TIME = "time";

            //Regarding to the Question "Where?"
            public static final String LOCATION = "location";

            //Regarding to the Question "What with?"
            public static final String SITUATION = "situation";

            //Regarding to the Question "What do you feel?"
            public static final String FEELING = "feeling";

            //Record the date of this self-monitoring result
            public static final String DATE = "date";
        }

    }
}
