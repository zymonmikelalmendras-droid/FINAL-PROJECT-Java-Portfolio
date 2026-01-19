package controller;

import java.util.ArrayList;
import model.AbstractTask;

public class TaskManager {
    private ArrayList<AbstractTask> tasks = new ArrayList<>();

    public void addTask(AbstractTask task) {
        tasks.add(task);
    }

    public ArrayList<AbstractTask> getTasks() {
        return tasks;
    }

    public int generateTaskId() {
        return tasks.size() + 1;
    }
}