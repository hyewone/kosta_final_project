<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">������ ��Ͻ�û</h2>
	</div>
<form class="form-horizontal" action="insertCaregiver"
enctype="multipart/form-data" method="post">

	<div class="form-group col-md-8 mb-3">
      <label for="cbank">�����:</label>
      <input type="text" class="form-control" id="cbank" name="cbank" placeholder="������� �Է��ϼ���.">
      </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="caccount">���¹�ȣ:</label>
      <input type="text" class="form-control" id="caccount" name="caccount" placeholder="���¹�ȣ�� �Է��ϼ���.">
       <input type="button" id="chkcaccount" name="chkcaccount" value="�����ߺ�Ȯ��">
      <p id="chk_account"></p>
    </div>
   <div class="form-group col-md-8 mb-3 text-right">
	   <label for="cbank">�ڰ��� �̹���:</label>
	   <input type="file" name="multipartFile">
   </div>
   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="���� �Է��ϱ�">
    <input type="submit" id="request" class="btn btn-info" value="��û">
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