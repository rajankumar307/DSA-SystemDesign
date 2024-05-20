package com.ratelimiter;

public interface RateLimiterStrategy {
     boolean allowRequest(String userId);
}
