package com.bma.directory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bma.directory.vo.output.StudentDtlsResponseVO;

@EnableJpaRepositories
@Component
@Repository
public interface IStudentDirectoryServiceDAO extends JpaRepository<StudentDtlsResponseVO, Integer> {

}
