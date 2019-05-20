package com.disqo.notemanagement.config;

import com.disqo.notemanagement.helper.LocalDateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.Formatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {

	@Bean
	@Primary
	public Formatter<LocalDate> localDateFormatter() {
		return new LocalDateFormatter();
	}
}
