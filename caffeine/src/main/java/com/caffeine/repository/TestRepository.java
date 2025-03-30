package com.caffeine.repository;

import com.caffeine.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Repository
public class TestRepository {

    /**
     * 캐시에 값이 있다면 메소드 실행하지 않고 바로 리턴 합니다
     * 프록시 기반으로 동작하기 때문에 Self Invocation 에 주의해야 합니다.
     *
     * value : ehcache.xml에 설정한 캐시 이름 등록
     * key :해당 파라미터가 캐시의 키가 되도록 설정
     */
    @Cacheable(value = "memberCache", key="#memberId")
    public Member getMember(@PathVariable Long memberId) {
        log.info("get new member data");
        return Member.builder()
            .id(memberId)
            .name("od " + memberId)
            .build();
    }

    /*
        여러 캐시를 한꺼번에 삭제하는 경우
            @Caching(evict = {
                @CacheEvict(cacheNames="memberCache", key="#memberId"),
                @CacheEvict(cacheNames="memberCache2", key="#memberId"),
                // 키 값 없을 때
                @CacheEvict(cacheNames="getShopInfo", allEntries = true)
        })
	*/
    @CacheEvict(cacheNames="memberCache", key="#memberId")
    public void refresh (String memberId) {
        System.out.println("memberId 의 캐시를 삭제합니다");
    }
}
