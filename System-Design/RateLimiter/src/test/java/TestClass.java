package test.java;

import com.ratelimiter.Constants.RateLimiterConstant;
import com.ratelimiter.FixedRateWindowRateLimiter;
import com.ratelimiter.RateLimiter;
import com.ratelimiter.RateLimiterStrategy;
import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    @Test
   public void testForSingleUser(){
        RateLimiterStrategy rateLimiterStrategy=new FixedRateWindowRateLimiter(RateLimiterConstant.MAX_REQUESTS,RateLimiterConstant.WINDOW_SIZE);
        RateLimiter rateLimiter=new RateLimiter(rateLimiterStrategy);
        for(int i=0;i<10;i++){
            if(i<5)
                Assert.assertEquals(true,rateLimiter.allowRequest("user1"));
            else
                Assert.assertEquals(false,rateLimiter.allowRequest("user1"));
        }
   }
}
