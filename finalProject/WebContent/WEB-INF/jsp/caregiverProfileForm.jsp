<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">������ ������ ���</h2>
	</div>
<form class="form-horizontal" action="insertProfile"
enctype="multipart/form-data" method="post">

	<div class="form-group col-md-8 mb-3">
      <label for="cpname">������ �̸�:</label>
      <input type="text" class="form-control" id="cpname" name="cpname" placeholder="�̸��� �Է����ּ���.">
      </div>
    <div class="form-group col-md-8 mb-3 text-right">
	   <label for="cpimg">�������:</label>
	   <input type="file" name="multipartFile">
   </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpcareer">���:</label>
      <input type="text" class="form-control" id="cpcareeryear" name="cpcareeryear" placeholder="��� ����� �Է����ּ���.">
      <input type="text" class="form-control" id="cpcareermonth" name="cpcareermonth" placeholder="��� ������ �Է����ּ���.">
    </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpbirth">�������:</label>
      <input type="text" class="form-control" id="cpbirth" name="cpbirth" placeholder="��������� �Է����ּ���.">
    </div>
    <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cploc">��ȣ����:</label>
      <input type="text" class="form-control" id="cploc" name="cploc" placeholder="�ּҸ� �Է����ּ���.">
    </div>
     <div class="form-group col-md-8 mb-3" id="divInputId">
      <label for="cpintroduce">�ڱ�Ұ�:</label>
      <textarea class="form-control" rows="7" cols="" name="cpintroduce" id="cpintroduce"></textarea>
    </div>

   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="���� �Է��ϱ�">
    <input type="submit" id="request" class="btn btn-info" value="������ ���">
   </div>
    </form>
    </div>