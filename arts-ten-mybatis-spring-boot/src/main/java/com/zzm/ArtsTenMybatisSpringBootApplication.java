package com.zzm;

import com.zzm.dao.BlogMapper;
import com.zzm.intercept.ExamplePlugin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArtsTenMybatisSpringBootApplication implements CommandLineRunner {

	private final BlogMapper blogMapper;

	public ArtsTenMybatisSpringBootApplication(BlogMapper blogMapper) {
		this.blogMapper = blogMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(ArtsTenMybatisSpringBootApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		blogMapper.selectBlog(1);
	}
}
