<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">������ ������û</h2>
	</div>
<form class="form-horizontal" action="requestMonthly"
enctype="multipart/form-data" method="post">

	<div class="form-group col-md-8 mb-3">
      <label for="mondate">��û ��¥:</label>
      <input type="text" class="form-control" id="mondate" name="mondate" placeholder="������û��¥�� �Է����ּ���.">
      </div>
   <div class="form-group col-md-8 mb-3 text-right">
    <input type="button" id="reset" class="btn btn-info" value="���� �Է��ϱ�">
    <input type="submit" id="request" class="btn btn-info" value="��û">
   </div>
    </form>
    </div>