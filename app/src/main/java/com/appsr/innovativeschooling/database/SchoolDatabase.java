package com.appsr.innovativeschooling.database;

import android.content.Context;

import androidx.room.*;

import com.appsr.innovativeschooling.database.dao.ClassDao;
import com.appsr.innovativeschooling.database.dao.EventsDao;
import com.appsr.innovativeschooling.database.dao.ExamDao;
import com.appsr.innovativeschooling.database.dao.FeesDao;
import com.appsr.innovativeschooling.database.dao.HomeWorkDao;
import com.appsr.innovativeschooling.database.dao.ReportCardDao;
import com.appsr.innovativeschooling.database.dao.StudentAttendanceDao;
import com.appsr.innovativeschooling.database.dao.StudentProfileDao;
import com.appsr.innovativeschooling.database.dao.StudentPersonalDao;
import com.appsr.innovativeschooling.database.dao.SubjectDao;
import com.appsr.innovativeschooling.database.dao.TeacherAttendanceDao;
import com.appsr.innovativeschooling.database.dao.TeacherProfileDao;
import com.appsr.innovativeschooling.database.dao.TeacherPersonalDao;
import com.appsr.innovativeschooling.database.dao.TimeTableDao;
import com.appsr.innovativeschooling.models.Classes;
import com.appsr.innovativeschooling.models.Events;
import com.appsr.innovativeschooling.models.ExamTimeTable;
import com.appsr.innovativeschooling.models.Fees;
import com.appsr.innovativeschooling.models.HomeWork;
import com.appsr.innovativeschooling.models.ReportCard;
import com.appsr.innovativeschooling.models.StudentAttendance;
import com.appsr.innovativeschooling.models.StudentPersonalProfile;
import com.appsr.innovativeschooling.models.StudentProfile;
import com.appsr.innovativeschooling.models.Subject;
import com.appsr.innovativeschooling.models.TeacherAttendance;
import com.appsr.innovativeschooling.models.TeacherPersonalProfile;
import com.appsr.innovativeschooling.models.TeacherProfile;
import com.appsr.innovativeschooling.models.TimeTable;


@Database(entities = {
        StudentProfile.class, StudentPersonalProfile.class, TeacherProfile.class,
        TeacherPersonalProfile.class, Fees.class, StudentAttendance.class,
        TeacherAttendance.class, ReportCard.class, ExamTimeTable.class,Classes.class,
        HomeWork.class, Subject.class, Events.class, TimeTable.class}, version = 1, exportSchema = false)
public abstract class SchoolDatabase extends RoomDatabase {

    public abstract StudentProfileDao studentDao();
    public abstract StudentPersonalDao studentPersonalDao();
    public abstract TeacherProfileDao teacherDao();
    public abstract TeacherPersonalDao teacherPersonalDao();
    public abstract FeesDao feesDao();
    public abstract ReportCardDao reportCardDao();
    public abstract ExamDao examDao();
    public abstract TimeTableDao timeTableDao();
    public abstract EventsDao eventsDao();
    public abstract ClassDao classDao();
    public abstract SubjectDao subjectDao();
    public abstract HomeWorkDao homeWorkDao();

    public abstract StudentAttendanceDao studentAttendanceDao();
    public abstract TeacherAttendanceDao teacherAttendanceDao();

    private static volatile SchoolDatabase INSTANCE;

    public static SchoolDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SchoolDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    SchoolDatabase.class, "school_database")
                            .fallbackToDestructiveMigration() // If database version is changed, recreate DB
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
















