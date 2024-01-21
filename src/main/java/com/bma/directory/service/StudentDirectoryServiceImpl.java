package com.bma.directory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bma.directory.dao.IStudentDirectoryServiceDAO;
import com.bma.directory.util.StudentDetailsConstants;
import com.bma.directory.vo.input.StudentDetailsRequestVO;
import com.bma.directory.vo.input.StudentDtlsRequestVO;
import com.bma.directory.vo.output.StudentDetailsResponseVO;
import com.bma.directory.vo.output.StudentDtlsResponseVO;

@Component
public class StudentDirectoryServiceImpl implements IStudentDirectoryService {

	@Autowired
	private IStudentDirectoryServiceDAO iStudentDirectoryDAO;

	@Override
	public StudentDetailsResponseVO getStudentDetails(StudentDetailsRequestVO studentDetailsRequestVO) {
		StudentDetailsResponseVO studentDetailsResponseVO = new StudentDetailsResponseVO();
		List<StudentDtlsResponseVO> studentDtlsResponseVO = iStudentDirectoryDAO.findAll();
		studentDetailsResponseVO.setStudentDtlsResponseVO(studentDtlsResponseVO);
		return studentDetailsResponseVO;
	}

	@Override
	public StudentDetailsResponseVO calculateStudentBill(StudentDetailsRequestVO studentDetailsInputVO) {
		StudentDetailsResponseVO studentDetailsResponseVO = new StudentDetailsResponseVO();
		List<StudentDtlsResponseVO> studentDtlsResponseVO = iStudentDirectoryDAO.findAll();
		studentDtlsResponseVO = iStudentDirectoryDAO
				.saveAll(populateStudentDtlsOutputVO(studentDetailsInputVO));
		studentDetailsResponseVO.setStudentDtlsResponseVO(studentDtlsResponseVO);
		return studentDetailsResponseVO;
	}

	private List<StudentDtlsResponseVO> populateStudentDtlsOutputVO(StudentDetailsRequestVO studentDetailsRequestVO) {
		List<StudentDtlsResponseVO> studentDtlsResponseVOs = new ArrayList<>();
		StudentDtlsResponseVO studentDtlsResponseVO = new StudentDtlsResponseVO();
		for (StudentDtlsRequestVO studentDtlsRequestVO : studentDetailsRequestVO.getStudentDtlsRequestVO()) {
			studentDtlsResponseVO.setStudentId(studentDtlsRequestVO.getStudentId());
			studentDtlsResponseVO.setStudentName(studentDtlsRequestVO.getStudentName());
			studentDtlsResponseVO.setStudentGrade(studentDtlsRequestVO.getStudentGrade());
			studentDtlsResponseVO.setStudentScore(studentDtlsRequestVO.getStudentScore());
			studentDtlsResponseVO.setMonthlyBill(calculateMonthlyBill(studentDtlsRequestVO.getStudentScore(),
					studentDtlsRequestVO.getStudentGrade()));
			studentDtlsResponseVO.setQuarterlyBill(
					String.valueOf(Double.parseDouble(calculateMonthlyBill(studentDtlsRequestVO.getStudentScore(),
							studentDtlsRequestVO.getStudentGrade())) * 3));
		}
		studentDtlsResponseVOs.add(studentDtlsResponseVO);
		return studentDtlsResponseVOs;
	}

	private String calculateMonthlyBill(String studentScore, String studentGrade) {
		// TODO Auto-generated method stub
		int score = Integer.parseInt(studentScore);
		switch (studentGrade) {
		case "1": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_ONE, score));
		}
		case "2": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_TWO, score));
		}
		case "3": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_THREE, score));
		}
		case "4": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_FOUR, score));
		}
		case "5": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_FIVE, score));
		}
		case "6": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_SIX, score));
		}
		case "7": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_SEVEN, score));
		}
		case "8": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_EIGHT, score));
		}
		case "9": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_NINE, score));
		}
		case "10": {
			return String.valueOf(calculateBill(StudentDetailsConstants.GRADE_TEN, score));
		}
		default:
			throw new IllegalArgumentException("Enter valid grade" + studentGrade);
		}

	}

	private double calculateBill(int grade, int score) {
		if (score < 60)
			return grade;
		else if (score >= 60 && score < 70)
			return grade - grade * 0.1;
		else if (score >= 70 && score < 80)
			return grade - grade * 0.2;
		else if (score >= 90)
			return grade - grade * 0.3;
		return 0;
	}

}
