<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">������ ������ ����</h2>
	</div>
<form class="form-horizontal" action="updateProfile"
enctype="multipart/form-data" method="post">

	<input type="hidden" id="cpno" name="cpno" value="${cpvo.cpno}"/>
	<input type="hidden" id="cno" name="cno" value="${cpvo.cno}"/>
	
	<div class="form-group col-md-8 mb-3">
      <label for="cpname">������ �̸�:</label>
      <input value="${cpvo.cpname}" type="text" class="form-control" id="cpname" name="cpname" placeholder="�̸��� �Է����ּ���.">
      </div>
    <div class="form-group col-md-8 mb-3 text-right">
	   <label for="cpimg">�������:</label>
	   <img src="resources/imgfile/${cpvo.cpimg}">
	   <input type="hidden" id="cpimg" name="cpimg" value="${cpvo.cpimg}"/> 
	   <input type="file" name="multipartFile" value="${cpvo.cpimg}">
   </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpcareer">���:</label>
      <input value="${cpvo.cpcareeryear}" type="text" class="form-control" id="cpcareeryear" name="cpcareeryear" placeholder="��� ����� �Է����ּ���.">
      <input value="${cpvo.cpcareermonth}" type="text" class="form-control" id="cpcareermonth" name="cpcareermonth" placeholder="��� ������ �Է����ּ���.">
    </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpbirth">�������:</label>
      <input value="${cpvo.cpbirth}" type="text" class="form-control" id="cpbirth" name="cpbirth" placeholder="��������� �Է����ּ���.">
    </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cploc">��ȣ����:</label>
      <input value="${cpvo.cploc}" type="text" class="form-control" id="cploc" name="cploc" placeholder="�ּҸ� �Է����ּ���.">
    </div>
     <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpintroduce">�ڱ�Ұ�:</label>
      <textarea class="form-control" rows="7" cols="" name="cpintroduce" id="cpintroduce">${cpvo.cpintroduce}</textarea>
    </div>
    
    <div class="form-group col-md-8 mb-3">
      <label for="cpagree">������ ���� ����:</label>
      <input value="${cpvo.cpagree}" type="text" class="form-control" id="cpagree" name="cpagree" placeholder="�������θ� �Է����ּ���.">
    </div>

   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="���� �Է��ϱ�">
    <input type="button" id="cancel" class="btn btn-info" value="���">
    <input type="submit" id="request" class="btn btn-info" value="������ ����">
   </div>
    </form>
    </div>
