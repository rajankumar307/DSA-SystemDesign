package com.ratelimiter;

import com.ratelimiter.Models.UserRequestInfo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindowRateLimiter implements RateLimiterStrategy{

    private final int maxRequests;
    private final int windowSize;

    private final Map<String, LinkedList<Long>> userRequests;

    public SlidingWindowRateLimiter(int maxRequests,int windowSize){
        this.maxRequests=maxRequests;
        this.windowSize=windowSize;
        this.userRequests=new HashMap<>();
    }
    @Override
    public boolean allowRequest(String userId) {

        long currentTime=System.currentTimeMillis()/1000;
        userRequests.putIfAbsent(userId,new LinkedList<>());
        LinkedList<Long> list=userRequests.get(userId);

        list.removeIf(req->req<currentTime-windowSize);
        if(list.size()<maxRequests)
        {
            list.addLast(currentTime);
            return true;
        }
        return false;
    }
}
