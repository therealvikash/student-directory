package com.bma.directory.vo.input;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtlsRequestVO {

	private int studentId;

	private String studentName;

	private String studentGrade;

	private String studentScore;
}
