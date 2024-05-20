package com.ratelimiter;

import com.ratelimiter.Constants.RateLimiterConstant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        RateLimiterStrategy fixedRateLimiterStrategy=
                new FixedRateWindowRateLimiter(RateLimiterConstant.MAX_REQUESTS,RateLimiterConstant.WINDOW_SIZE);

        RateLimiter rateLimiter=new RateLimiter(fixedRateLimiterStrategy);


        for(int i=0;i<10;i++){
            if(rateLimiter.allowRequest("user1"))
                System.out.println("Request "+(i+1)+" allowed for user1");
            else
                System.out.println("Request "+(i+1)+" not allowed for user1");

            if(rateLimiter.allowRequest("user2"))
                System.out.println("Request "+(i+1)+" allowed for user2");
            else
                System.out.println("Request "+(i+1)+" not allowed for user2");
        }
    }
}