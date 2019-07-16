package com.example.washsauce_dev;

import java.util.List;

//Interface created with the purpose of notifying when a list of 3 tasks is received by the WASHER.
public interface INotify3TasksReceived {
    void notifyTasksResult(List<Task> taskList);
}
