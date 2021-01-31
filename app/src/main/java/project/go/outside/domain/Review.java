package project.go.outside.domain;

import java.sql.Date;

public class Review {

  public int no; // 게시글 번호
  public int stars; // 평점
  public String title; // 제목
  public String content; // 게시글 내용
  public String password; // 암호
  public String writer; // 작성자 
  public Date registeredDate; // 작성일
  public int viewCount; // 조회수
  public int like; // 좋아요

}
