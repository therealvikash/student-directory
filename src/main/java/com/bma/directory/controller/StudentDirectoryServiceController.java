package com.bma.directory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bma.directory.service.StudentDirectoryServiceImpl;
import com.bma.directory.vo.error.CommonErrorVO;
import com.bma.directory.vo.input.StudentDetailsRequestVO;
import com.bma.directory.vo.output.StudentDetailsResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@SpringBootApplication
@RestController
@RequestMapping(value = "student/directory")
@Tag(name = "student/directory")
@ComponentScan(basePackages = "com.bma.service.studentdirectory")
public class StudentDirectoryServiceController {

	@Autowired
	private StudentDirectoryServiceImpl studentDirectoryServiceImpl;

	@Operation(method = "POST", summary = "Gets the billing details of students."
			+ "Sample URL -http://{....}/bma/studentdirectory/abc", description = "Gets the bill generated for student")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful", content = {
			@Content(mediaType = "applicayion/json", schema = @Schema(implementation = StudentDetailsResponseVO.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }),
			@ApiResponse(responseCode = "404", description = "Not Found", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }), })
	@PostMapping(value = "/read/studentdetails")
	public ResponseEntity<StudentDetailsResponseVO> getStudentDetails(
			@RequestBody StudentDetailsRequestVO studentDetailsInputVO) {
		StudentDetailsResponseVO studentDetailsOutputVO = studentDirectoryServiceImpl
				.getStudentDetails(studentDetailsInputVO);
		return new ResponseEntity<>(studentDetailsOutputVO, HttpStatus.CREATED);
	}

	@Operation(method = "POST", summary = "Calculates the monthly bills of student based on what grade they are studying."
			+ "Sample URL - http://{.....}/student/directory/service/write/studentdetails", description = "Post the information of one or more student to the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful", content = {
			@Content(mediaType = "applicayion/json", schema = @Schema(implementation = StudentDetailsResponseVO.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }),
			@ApiResponse(responseCode = "404", description = "Not Found", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "applicayion/json", schema = @Schema(implementation = CommonErrorVO.class)) }), })
	@PostMapping(value = "/write/studentdetails")
	public ResponseEntity<StudentDetailsResponseVO> calculateStudentBill(
			@RequestBody StudentDetailsRequestVO studentDetailsInputVO) {
		StudentDetailsResponseVO studentDetailsOutputVO = studentDirectoryServiceImpl
				.calculateStudentBill(studentDetailsInputVO);
		return new ResponseEntity<>(studentDetailsOutputVO, HttpStatus.CREATED);
	}
}