package com.ratelimiter;

public class RateLimiter {

    private final RateLimiterStrategy rateLimiterStrategy;

    public RateLimiter(RateLimiterStrategy rateLimiterStrategy){
        this.rateLimiterStrategy=rateLimiterStrategy;
    }
    public boolean allowRequest(String userId){
        return rateLimiterStrategy.allowRequest(userId);
    }
}
