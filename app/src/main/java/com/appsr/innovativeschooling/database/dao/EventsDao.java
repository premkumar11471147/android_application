package com.appsr.innovativeschooling.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.appsr.innovativeschooling.models.Events;

import java.util.List;

@Dao
public interface EventsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEvent(Events event);

    @Update
    void updateEvent(Events event);

    @Delete
    void deleteEvent(Events event);

    @Query("SELECT * FROM events WHERE event_id = :id")
    LiveData<Events> getEventById(int id);


    @Query("SELECT * FROM events WHERE event_date >= :date")
    LiveData<List<Events>> getUpcomingEvents(String date);
}
