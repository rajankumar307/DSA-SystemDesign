package com.ratelimiter;

import com.ratelimiter.Models.UserRequestInfo;

import java.util.HashMap;
import java.util.Map;

public class FixedRateWindowRateLimiter implements RateLimiterStrategy {

    private final int maxRequests;
    private final int windowSize;

    private final Map<String, UserRequestInfo> userRequests;

    public FixedRateWindowRateLimiter(int maxRequests,int windowSize){
        this.maxRequests=maxRequests;
        this.windowSize=windowSize;
        this.userRequests=new HashMap<>();
    }
    @Override
    public boolean allowRequest(String userId) {
        long currTime=System.currentTimeMillis()/1000;
        long windowStarts=(currTime/windowSize)*windowSize;

        UserRequestInfo userRequestInfo=userRequests.getOrDefault(userId,new UserRequestInfo(windowStarts,0));
        if(userRequestInfo.getWindowStarts()!=windowStarts)
        {
            userRequestInfo.setWindowStarts(windowStarts);
            userRequestInfo.setRequestCount(0);
        }
        if(userRequestInfo.getRequestCount()<maxRequests){
            userRequestInfo.setRequestCount(userRequestInfo.getRequestCount()+1);
            userRequests.put(userId,userRequestInfo);
            return true;
        }
        return false;
    }
}
