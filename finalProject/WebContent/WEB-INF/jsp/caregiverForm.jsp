<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">간병인 등록신청</h2>
	</div>
<form class="form-horizontal" action="insertCaregiver"
enctype="multipart/form-data" method="post">

	<div class="form-group col-md-8 mb-3">
      <label for="cbank">은행명:</label>
      <input type="text" class="form-control" id="cbank" name="cbank" placeholder="은행명을 입력하세요.">
      </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="caccount">계좌번호:</label>
      <input type="text" class="form-control" id="caccount" name="caccount" placeholder="계좌번호를 입력하세요.">
       <input type="button" id="chkcaccount" name="chkcaccount" value="계좌중복확인">
      <p id="chk_account"></p>
    </div>
   <div class="form-group col-md-8 mb-3 text-right">
	   <label for="cbank">자격증 이미지:</label>
	   <input type="file" name="multipartFile">
   </div>
   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="새로 입력하기">
    <input type="submit" id="request" class="btn btn-info" value="신청">
   </div>
    </form>
    </div>
    
    <script>
    $(function(){
        $('#chkcaccount').click(function(){
            var caccount = document.getElementById("caccount").value;
           $.ajax({
              url : "chkaccount",
              data :{ "caccount" : caccount },
              success : function(data){
   				console.log(data);
   				document.getElementById('chk_account').innerHTML=data;
           }
        });
        });
    });
    
    </script>