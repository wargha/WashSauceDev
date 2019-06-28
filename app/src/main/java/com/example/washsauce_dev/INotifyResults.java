package com.example.washsauce_dev;

import java.util.Map;

public interface INotifyResults {
    interface notifyActivity {
        public Map<String, Object> notifyResult(User user);
    }
}
