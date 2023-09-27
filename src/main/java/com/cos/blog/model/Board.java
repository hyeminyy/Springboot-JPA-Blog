package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cos.blog.model.User;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
@Id //primary key
@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
private int id; //auto_increment

@Column(nullable = false, length = 100)
private String title;

@Lob
private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨

private int count; //조회수

@ManyToOne(fetch = FetchType.EAGER)  //many = board, user = one
@JoinColumn(name="userId")
private User user; //db는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.

@OneToMany(mappedBy = "board", fetch = FetchType.LAZY) //mappedBy 연관관계의 주인이 아니다. (난 FK가 아니다.)DB에 칼럼을 만들지
private List<Reply> reply;

@CreationTimestamp
private Timestamp createDate;
}
