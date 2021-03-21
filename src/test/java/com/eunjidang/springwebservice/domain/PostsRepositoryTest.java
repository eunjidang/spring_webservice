package com.eunjidang.springwebservice.domain;

import com.eunjidang.springwebservice.domain.entity.Posts;
import com.eunjidang.springwebservice.repository.PostsRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/* Junit 테스트 프레임워크로 테스트 코드 작성하기
*  테스트코드는 메모리 DB인 H2를 기본적으로 사용
*  (테스트 코드 실행시점에 H2 DB 실행, 테스트가 끝나면 같이 종료 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){

        //BDD (Behaviour-Driven Development)
        //given 테스트 기반 환경을 구축하는 단계
        postsRepository.save(Posts.builder()
                        .title("테스트 게시글")
                        .content("테스트 본문")
                        .author("ejbm2013@naver.com")
                        .build());

        //when 테스트하고자하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();

        //then 테스트 결과 검증
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));

    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                        .title("테스트 게시글2")
                        .content("테스트 본문2")
                        .author("ejej")
                        .build());
        //when
        List<Posts> postList = postsRepository.findAll();

        //then
        Posts posts = postList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));

    }


}
