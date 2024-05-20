package com.ratelimiter.Models;

public class UserRequestInfo {

    long windowStarts;

    public long getWindowStarts() {
        return windowStarts;
    }

    public int getRequestCount() {
        return requestCount;
    }

    int requestCount;

    public UserRequestInfo(long windowStarts,int requestCount){
        this.requestCount=requestCount;
        this.windowStarts=windowStarts;
    }

    public void setWindowStarts(long windowStarts) {
        this.windowStarts = windowStarts;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }
}
