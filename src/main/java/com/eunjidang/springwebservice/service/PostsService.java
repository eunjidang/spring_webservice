package com.eunjidang.springwebservice.service;

import com.eunjidang.springwebservice.dto.posts.PostsSaveRequestDto;
import com.eunjidang.springwebservice.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}
