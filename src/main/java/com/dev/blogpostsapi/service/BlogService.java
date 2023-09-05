package com.dev.blogpostsapi.service;

import com.dev.blogpostsapi.data.entity.Blog;
import com.dev.blogpostsapi.data.repository.AuthorRepository;
import com.dev.blogpostsapi.data.repository.BlogRepository;
import com.dev.blogpostsapi.error.BadRequestException;
import com.dev.blogpostsapi.error.ConflictException;
import com.dev.blogpostsapi.error.NotFoundException;
import com.dev.blogpostsapi.model.BlogDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthorRepository authorRepository;

    public BlogService(BlogRepository blogRepository, AuthorRepository authorRepository) {
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }

    public List<BlogDTO> getAllBlogs(){
        Iterable<Blog> blogEntities = blogRepository.findAll();
        List<BlogDTO> blogs = new ArrayList<>();

        blogEntities.forEach(entity ->{
            blogs.add(translateToBlogDTO(entity));
        });

        return blogs;
    }

    public BlogDTO getBlogById(int id){
       if (id <= 0 || id > 100 || ! blogRepository.existsById(id)){
            throw new BadRequestException("Invalid id. Please enter a valid id in range [1-100]");
       }
       return translateToBlogDTO(blogRepository.findById(id).get());
    }

    public BlogDTO createBlog(BlogDTO blogDTO){
        if(blogRepository.existsById(blogDTO.getId())){
            throw new ConflictException("Blog already exist.");
        }
        Blog blog = blogRepository.save(translateToBlog(blogDTO));
        return translateToBlogDTO(blog) ;
    }

    public BlogDTO updateBlog(BlogDTO blogDTO){
        if (blogDTO.getId() <= 0 || !blogRepository.existsById(blogDTO.getId())){
            throw new NotFoundException("The Blog your are trying to update doesn't exist");
        }
        blogRepository.findById(blogDTO.getId())
                .ifPresent(blog -> {
                    blog.setBlogTitle(blogDTO.getTitle());
                    blog.setBlogBody(blogDTO.getBody());
                    blog.setPublishDate(blogDTO.getPublishDate());
                });
        Optional<Blog> blogEntity = blogRepository.findById(blogDTO.getId());
        return translateToBlogDTO(blogEntity.get());
    }

    public void deleteBlog(int id){
        Optional<Blog> blog = this.blogRepository.findById(id);
        this.blogRepository.delete(blog.get());
    }


    private Blog translateToBlog(BlogDTO blogDTO ){
        return new Blog(
                blogDTO.getId(),
                blogDTO.getTitle(),
                authorRepository.findById(blogDTO.getAuthorId()).get(),
                blogDTO.getPublishDate(),
                blogDTO.getBody()
        );
    }
    private BlogDTO translateToBlogDTO(Blog blog){
        return new BlogDTO(
                blog.getBlogId(),
                blog.getBlogTitle(),
                blog.getBlogBody(),
                blog.getPublishDate(),
                blog.getAuthor().getId(),
                blog.getAuthor().getFirstName() + " "+
                blog.getAuthor().getLastName()
        );    }
}
