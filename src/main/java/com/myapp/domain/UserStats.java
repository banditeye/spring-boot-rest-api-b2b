package com.myapp.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Value;

/**
 * Liczba postow, follower i followings
 * @author Kamil Wiśniewski 
 */


@Value
@Builder
public class UserStats {

    private final long micropostCnt;
    private final long followingCnt;
    private final long followerCnt;

    @QueryProjection
    public UserStats(long micropostCnt, long followingCnt, long followerCnt) {
        this.micropostCnt = micropostCnt;
        this.followingCnt = followingCnt;
        this.followerCnt = followerCnt;
    }

}
