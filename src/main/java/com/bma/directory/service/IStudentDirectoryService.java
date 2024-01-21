package com.bma.directory.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bma.directory.vo.input.StudentDetailsRequestVO;
import com.bma.directory.vo.output.StudentDetailsResponseVO;

@Service
@Component
public interface IStudentDirectoryService {

	StudentDetailsResponseVO getStudentDetails(StudentDetailsRequestVO studentDetailsInputVO);

	StudentDetailsResponseVO calculateStudentBill(StudentDetailsRequestVO studentDetailsInputVO);
}
