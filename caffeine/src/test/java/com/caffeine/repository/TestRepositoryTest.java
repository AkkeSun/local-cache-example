package com.caffeine.repository;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class TestRepositoryTest {

    @Autowired
    TestRepository testRepository;

    @Nested
    @DisplayName("[사용자 정보를 조회하는 메소드]")
    class Describe_getMember {

        @Test
        @DisplayName("[success] 캐시 데이터가 있다면 캐시 데이터를 응답한다.")
        void success (CapturedOutput output) {
            // given
            Long memberId = 10L;
            testRepository.getMember(memberId);

            // when
            testRepository.getMember(memberId);

            // then
            assert output.toString().split("get new member data").length == 2;
        }
    }
}