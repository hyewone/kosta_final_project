<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">������ ������û</h2>
	</div>
<form class="form-horizontal" action="requestUpdateMonthly"
enctype="multipart/form-data" method="post">

	<input type="hidden" id="conno" name="conno" value="${monvo.conno}"/>
	
	<div class="form-group col-md-8 mb-3">
      <label for="mondate">��û ��¥:</label>
      <input value="${monvo.mondate}" type="text" class="form-control" id="mondate" name="mondate" placeholder="������û��¥�� �Է����ּ���.">
      </div>
   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="���� �Է��ϱ�">
    <input type="button" id="cancel" class="btn btn-info" value="���">
    <input type="submit" id="request" class="btn btn-info" value="����">
   </div>
    </form>
    </div>