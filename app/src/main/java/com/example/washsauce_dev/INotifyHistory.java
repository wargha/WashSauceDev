package com.example.washsauce_dev;

import java.util.List;
//Interface created with the purpose of notifying when a history of tasks received by the USER.
public interface INotifyHistory {
    void notifyTasksHistoryResult(List<Task> taskList);
}
