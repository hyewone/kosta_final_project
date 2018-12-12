<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">간병인 프로필 등록</h2>
	</div>
<form class="form-horizontal" action="insertProfile"
enctype="multipart/form-data" method="post">

	<div class="form-group col-md-8 mb-3">
      <label for="cpname">간병인 이름:</label>
      <input type="text" class="form-control" id="cpname" name="cpname" placeholder="이름을 입력해주세요.">
      </div>
    <div class="form-group col-md-8 mb-3 text-right">
	   <label for="cpimg">증명사진:</label>
	   <input type="file" name="multipartFile">
   </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpcareer">경력:</label>
      <input type="text" class="form-control" id="cpcareeryear" name="cpcareeryear" placeholder="경력 년수를 입력해주세요.">
      <input type="text" class="form-control" id="cpcareermonth" name="cpcareermonth" placeholder="경력 월수를 입력해주세요.">
    </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpbirth">생년월일:</label>
      <input type="text" class="form-control" id="cpbirth" name="cpbirth" placeholder="생년월일을 입력해주세요.">
    </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cploc">선호지역:</label>
      <input type="text" class="form-control" id="cploc" name="cploc" placeholder="주소를 입력해주세요.">
    </div>
     <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpintroduce">자기소개:</label>
      <textarea class="form-control" rows="7" cols="" name="cpintroduce" id="cpintroduce"></textarea>
    </div>

   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="새로 입력하기">
    <input type="submit" id="request" class="btn btn-info" value="프로필 등록">
   </div>
    </form>
    </div>