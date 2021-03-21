package com.eunjidang.springwebservice.web;

import com.eunjidang.springwebservice.repository.PostsRepository;
import com.eunjidang.springwebservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* Bean 주입받을 때, Autowired가 아닌 생성자로 주입받도록 한다.
   생성자는 @AllArgsContructor 에서 해결해줌
   == postRepository를 받은 생성자를 만드는 것
 */
@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld!";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

}
