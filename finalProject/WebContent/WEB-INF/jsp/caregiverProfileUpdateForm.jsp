<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">간병인 프로필 수정</h2>
	</div>
<form class="form-horizontal" action="updateProfile"
enctype="multipart/form-data" method="post">

	<input type="hidden" id="cpno" name="cpno" value="${cpvo.cpno}"/>
	<input type="hidden" id="cno" name="cno" value="${cpvo.cno}"/>
	
	<div class="form-group col-md-8 mb-3">
      <label for="cpname">간병인 이름:</label>
      <input value="${cpvo.cpname}" type="text" class="form-control" id="cpname" name="cpname" placeholder="이름을 입력해주세요.">
      </div>
    <div class="form-group col-md-8 mb-3 text-right">
	   <label for="cpimg">증명사진:</label>
	   <img src="resources/imgfile/${cpvo.cpimg}">
	   <input type="hidden" id="cpimg" name="cpimg" value="${cpvo.cpimg}"/> 
	   <input type="file" name="multipartFile" value="${cpvo.cpimg}">
   </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpcareer">경력:</label>
      <input value="${cpvo.cpcareeryear}" type="text" class="form-control" id="cpcareeryear" name="cpcareeryear" placeholder="경력 년수를 입력해주세요.">
      <input value="${cpvo.cpcareermonth}" type="text" class="form-control" id="cpcareermonth" name="cpcareermonth" placeholder="경력 월수를 입력해주세요.">
    </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpbirth">생년월일:</label>
      <input value="${cpvo.cpbirth}" type="text" class="form-control" id="cpbirth" name="cpbirth" placeholder="생년월일을 입력해주세요.">
    </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cploc">선호지역:</label>
      <input value="${cpvo.cploc}" type="text" class="form-control" id="cploc" name="cploc" placeholder="주소를 입력해주세요.">
    </div>
     <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpintroduce">자기소개:</label>
      <textarea class="form-control" rows="7" cols="" name="cpintroduce" id="cpintroduce">${cpvo.cpintroduce}</textarea>
    </div>
    
    <div class="form-group col-md-8 mb-3">
      <label for="cpagree">프로필 공개 여부:</label>
      <input value="${cpvo.cpagree}" type="text" class="form-control" id="cpagree" name="cpagree" placeholder="공개여부를 입력해주세요.">
    </div>

   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="새로 입력하기">
    <input type="button" id="cancel" class="btn btn-info" value="취소">
    <input type="submit" id="request" class="btn btn-info" value="프로필 수정">
   </div>
    </form>
    </div>
