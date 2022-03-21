package com.example.rewardpoints.service.impl;

import com.example.rewardpoints.service.RewardPointsCalculatorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RewardPointsCalculatorServiceImpl implements RewardPointsCalculatorService {
    @Value("${breakpointOne}")
    private Float breakpointOne;
    @Value("${breakpointOneMultiplier}")
    private Float breakpointOneMultiplier;
    @Value("${breakpointTwo}")
    private Float breakpointTwo;
    @Value("${breakpointTwoMultiplier}")
    private Float breakpointTwoMultiplier;
    @Override
    public Float calculateRewardPoints(Float dollarsSpent){
        if(dollarsSpent > breakpointTwo)
            return breakpointTwoMultiplier * (dollarsSpent - breakpointTwo) + breakpointOneMultiplier * (breakpointTwo - breakpointOne);
        else if(dollarsSpent > breakpointOne)
            return breakpointOneMultiplier * (dollarsSpent - breakpointOne);
        else
            return 0F;
    }

}
