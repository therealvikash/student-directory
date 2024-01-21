package com.bma.directory.vo.input;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class StudentDetailsRequestVO {	
	private List<StudentDtlsRequestVO> studentDtlsRequestVO;
}
