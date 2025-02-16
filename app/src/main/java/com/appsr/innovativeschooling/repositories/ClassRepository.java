package com.appsr.innovativeschooling.repositories;

import androidx.lifecycle.LiveData;

import com.appsr.innovativeschooling.database.SchoolDatabase;
import com.appsr.innovativeschooling.database.dao.ClassDao;
import com.appsr.innovativeschooling.models.Classes;
import java.util.List;
import java.util.concurrent.Executors;

public class ClassRepository {
        private ClassDao dao;
        private LiveData<List<Classes>> allclasses;

        public ClassRepository(/*Application application*/) {
            SchoolDatabase db = null;// SchoolDatabase.getInstance(application);
            dao = db.classDao();
            allclasses = dao.getAllClasses();
        }

        public void insert(Classes classes) {
            Executors.newSingleThreadExecutor().execute(() -> dao.insertClass(classes));
        }

        public void update(Classes classes) {
            Executors.newSingleThreadExecutor().execute(() -> dao.updateClass(classes));
        }

        public void delete(Classes classes) {
            Executors.newSingleThreadExecutor().execute(() -> dao.deleteClass(classes));
        }

        public LiveData<List<Classes>> getAllEvents() {
            return allclasses;
        }
}
