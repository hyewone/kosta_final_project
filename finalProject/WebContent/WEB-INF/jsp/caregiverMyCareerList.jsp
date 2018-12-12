<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container mt-5">
	<div class="text-left">
		<h2 class="mb-3">간병인 등록신청</h2>
	</div>
  <table>
   <thead>
    <tr>
     <th colspan="6">경력 리스트</th>
    </tr>
    <tr>
     <td>경력번호</td>
     <td>계약번호</td>
     <td>근무지역</td>
     <td>근무기간</td>
     <td>근무상태</td>
    </tr>
   </thead>
   <tbody>
    <c:forEach var="ca" items="${conlist.calist}">
     <tr>
      <td>${ca.cano}</td>
      <td>${ca.conno}</td>
      <td>${conlist.conaddr1}</td>
      <td>${conlist.constartdate} ~ ${conlist.conenddate}</td>
      <td>${ca.castate}</td>
     </tr>
     <a href="downloadExcel?cno=${ca.cno}" style="color: black;">엑셀파일다운</a>
   </c:forEach>
   </tbody>
   <tfoot>
   </tfoot>
   </table>
   
   </div>
 