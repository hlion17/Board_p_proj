package model;

import lombok.Getter;
import lombok.Setter;


// pagination 구현 클래스
// 아직 적용 안함
@Getter
// @Setter
public class Pagination {
    /** 한 페이지당 게시글 수 **/
    @Setter
    private int pageSize = 10;  // limit

    /** 한 블럭(range)당 페이지 수 **/
    private int rangeSize = 3;  // default = 10

    /** 현재 페이지 **/
    @Setter
    private int curPage = 1;

    /** 현재 블럭(range) **/
    private int curRange = 1;

    /** 총 게시글 수 **/
//    @Setter
    private int listCnt;

    /** 총 페이지 수 **/
    private int pageCnt;

    /** 총 블럭(range) 수 **/
    private int rangeCnt;

    /** 시작 페이지 **/
    private int startPage = 1;

    /** 끝 페이지 **/
    private int endPage = 1;

    /** 시작 index **/
    private int startIndex = 0;

    /** 이전 페이지 **/
    private int prevPage;

    /** 다음 페이지 **/
    private int nextPage;

    public Pagination(int listCnt, int curPage){

        /**
         * 페이징 처리 순서
         * 1. 총 페이지수
         * 2. 총 블럭(range)수
         * 3. range setting
         */

        // 총 게시물 수와 현재 페이지를 Controller로 부터 받아온다.
        /** 현재페이지 **/
        setCurPage(curPage);
        /** 총 게시물 수 **/
//        setListCnt(listCnt);
        this.listCnt = listCnt;

        /** 1. 총 페이지 수 **/
        setPageCnt(listCnt);
        /** 2. 총 블럭(range)수 **/
        setRangeCnt(pageCnt);
        /** 3. 블럭(range) setting **/
        rangeSetting(curPage);

        /** DB 질의를 위한 startIndex 설정 **/
        setStartIndex(curPage);
    }

    // 총 페이지 개수
    // 총 게시물 수 / 페이지 당 게시물 수
    public void setPageCnt(int listCnt) {
        this.pageCnt = (int) Math.ceil(listCnt*1.0/pageSize);
    }

    // 페이지 블럭 수
    // 페이지 수 / 블럭 당 페이지 수
    public void setRangeCnt(int pageCnt) {
        this.rangeCnt = (int) Math.ceil(pageCnt*1.0/rangeSize);
    }

    // 현재 페이지 -> 현재 블럭 설정
    // 블럭의 시작페이지와 마지막 페이지
    public void rangeSetting(int curPage){

        setCurRange(curPage);
        this.startPage = (curRange - 1) * rangeSize + 1;
        this.endPage = startPage + rangeSize - 1;

        if(endPage > pageCnt){
            this.endPage = pageCnt;
        }

        this.prevPage = curPage - 1;
        this.nextPage = curPage + 1;
    }

    // 현재 블럭
    // 현재 페이지 / 블럭 사이즈
    public void setCurRange(int curPage) {
        this.curRange = (int) ((curPage - 1) / rangeSize) + 1;
    }

    // 페이지의 첫 게시물
    public void setStartIndex(int curPage) {
//        this.startIndex = (curPage - 1) * pageSize + 1;
        this.startIndex = (pageCnt - curPage) * pageSize + 1;
    }

}
