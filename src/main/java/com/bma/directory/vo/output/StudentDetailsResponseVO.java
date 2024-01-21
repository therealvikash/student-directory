package com.bma.directory.vo.output;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class StudentDetailsResponseVO {

	private List<StudentDtlsResponseVO> studentDtlsResponseVO;
}
