package com.homework.lms.student.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.homework.lms.role.service.IRoleService;
import com.homework.lms.student.service.IStudentService;

@Component
public class StudentUserService implements UserDetailsService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IRoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
		
		//selectMember >> userid로 회원 정보를 조회하는 메서드
		Student memberInfo = studentService.getStudent(studentId);
		if(memberInfo==null) {//로그인 X -> 반드시 !!!예외를 발생시켜야 함 -> 그래야 securityFilterChain에서 잡음
			throw new UsernameNotFoundException("["+studentId+"] 사용자가 없습니다.");
		}
		
		logger.info("StudentUserService " + memberInfo.toString());

		//test코드이므로 db에서 조회했다고 가정하고 작성하는 것
		String roleName = roleService.getRole(memberInfo.getRoleId()).getRoleName();
		String[] roles = {roleName};
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles);
		
		return new User(memberInfo.getStudentId(),memberInfo.getPassword(),authorities);
		
		//이메일도 반환하고 싶다면
		//스프링 시큐리티 세션에 아이디, 비번, 권한 외 정보 저장하는 방법
		//비번 암호화 했으니까 이제 평문을 나타네는 {noop}은 지워주자
//		return User(memberInfo.getUserid(), memberInfo.getPassword(), authorities, memberInfo.getEmail());
	}

}
