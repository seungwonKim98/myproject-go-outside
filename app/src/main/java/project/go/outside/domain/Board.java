package project.go.outside.domain;

import java.sql.Date;

public class Board {

  public int no; // 게시글 번호
  public String title; // 글 제목
  public String content; // 글 내용
  public String writer; // 작성자 이름
  public String password; // 비밀 번호
  public Date registeredDate; // 작성일
  public int viewCount; // 조회수
  public int like; // 좋아요

}
