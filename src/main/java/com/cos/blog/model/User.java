package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //user class가 자동으로 MySQL에 테이블이 생성이 된다.
//@DynamicInsert //insert시에 null인 필드를 제외시켜준다.
public class User {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; //auto_increment
	
	@Column(nullable = false, length = 30)
	private String username; //id
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//DB는 RoleType이라는게 없다.
	//@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다. , ADMIN(관리자), USER, MANAGER 3개의 권한을 주는.. 
	
	@CreationTimestamp //시간이 자동 입력 
	private Timestamp createDate; //회원이 가입한 시간 
}