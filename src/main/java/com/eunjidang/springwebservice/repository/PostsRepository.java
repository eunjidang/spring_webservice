package com.eunjidang.springwebservice.repository;

import com.eunjidang.springwebservice.domain.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

/* DB Layer 접근자 
*  인터페이스 생성 후 JpaRepository<Entity클래스, PK타입> 선언하면
*  기본적으로 CRUD 메소드가 자동생성 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
