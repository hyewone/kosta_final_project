<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">간병인 월차신청</h2>
	</div>
<form class="form-horizontal" action="requestUpdateMonthly"
enctype="multipart/form-data" method="post">

	<input type="hidden" id="conno" name="conno" value="${monvo.conno}"/>
	
	<div class="form-group col-md-8 mb-3">
      <label for="mondate">신청 날짜:</label>
      <input value="${monvo.mondate}" type="text" class="form-control" id="mondate" name="mondate" placeholder="월차신청날짜를 입력해주세요.">
      </div>
   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="새로 입력하기">
    <input type="button" id="cancel" class="btn btn-info" value="취소">
    <input type="submit" id="request" class="btn btn-info" value="수정">
   </div>
    </form>
    </div>