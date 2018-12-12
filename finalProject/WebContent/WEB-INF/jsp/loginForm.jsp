<%@ page contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<div id="article">
   <div id="header2">
      <div id="loginWrap">
         <h3>로그인하셈</h3>

         <form action="login" method="post">
            UserID: <input type="text" name="id" /> <br>
            Password: <input type="password" name="upwd" /><br>
            <div>
               <input name="submit" type="submit" value="login">
               <input name="idch" id="idch" type="button" value="id찾기"> 
               <input name="pwdch" id="pwdch" type="button" value="비번찾기">
            </div>
         </form>

         <!-- 아이디 찾기 Modal -->
         <div id="myModal1" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
               <p style="text-align: center;">
                  <span style="font-size: 14pt;"><b><span
                        style="font-size: 24pt;">아이디 찾기</span></b></span>
               </p>
               <p style="text-align: center; line-height: 1.5;">
                  <br />가입할때 기입했던 이름과 이메일,연락처를 써주세요
               </p>
               이메일<input id="uemail" type="text" name="uemail" value="soyoon5@naver.com"><br>
               연락처 <input id="uphone" type="text" name="uphone" value="010-7546-8521"><br>
               <input id="idck" type="button" value="찾기" />
               <p id="target"></p>
               <p>
                  <br />
               </p>
               <div
                  style="cursor: pointer; background-color: #DDDDDD; text-align: center; padding-bottom: 10px; padding-top: 10px;"
                  onClick="close_pop();">
                  <span class="pop_bt" style="font-size: 13pt;"> 닫기 </span>
               </div>
            </div>

         </div>
         
          <!-- 비밀번호 찾기 Modal -->
         <div id="myModal2" class="modal">

            Modal content
            <div class="modal-content">
               <p style="text-align: center;">
                  <span style="font-size: 14pt;"><b><span
                        style="font-size: 24pt;">비밀번호 찾기</span></b></span>
               </p>
               <p style="text-align: center; line-height: 1.5;">
                  <br />가입할때 기입했던 id와 이메일,연락처를 써주세요
               </p>
               아이디 <input type="text" name="uid"><br>
               이메일 <input type="text" name="uemail"><br>
               연락처 <select id="ComboBox" name="uphone">
                     <option value="010">010</option>
                     <option value="011">011</option>
                     <option value="017">017</option>
                     <option value="018">018</option>
                     </select>
                     -<input size="4px" type="text" name="uphone">-<input size="4px" type="text" name="uphone"><br>
               <input id="pwdck" type="button" value="찾기" >
               <p id="target"></p>
               <p>
                  <br />
               </p>
               <div
                  style="cursor: pointer; background-color: #DDDDDD; text-align: center; padding-bottom: 10px; padding-top: 10px;"
                  onClick="close_pop();">
                  <span class="pop_bt" style="font-size: 13pt;"> 닫기 </span>
              	<input type="hidden" value="${msg}">
               </div>
            </div>

         </div> 
         
      </div>
   </div>
</div>
 <script src="https://code.jquery.com/jquery-latest.js"></script> 
 <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
 <script type="text/javascript">
 
 $(function(){
     $('#idck').click(function(){
         var uemail = document.getElementById("uemail").value;
         var uphone = document.getElementById("uphone").value;
        $.ajax({
           url : "mybatisList",
           data :{ "uemail" : uemail,
        	   "uphone" : uphone },
           success : function(data){
        	   //let tag;
				//$("#target").html(data);
				console.log(data);
				document.getElementById('target').innerHTML=data;
        }
     });
     });
 });
 
      //아이디 찾기 모달 띄우기
       $("#idch").click(function() {
                $('#myModal1').show();
        });
       
      //비밀번호 찾기 모달 띄우기
       $("#pwdch").click(function() {
               $('#myModal2').show();
       });
      
       //팝업 Close 기능
       function close_pop(flag) {
          $('#myModal1').hide();
          $('#myModal2').hide();
       };
        
    </script>


<style>
/* The Modal (background) */
.modal {
   display: none; /* Hidden by default */
   position: fixed; /* Stay in place */
   z-index: 1; /* Sit on top */
   left: 0;
   top: 0;
   width: 100%; /* Full width */
   height: 100%; /* Full height */
   overflow: auto; /* Enable scroll if needed */
   background-color: rgb(0, 0, 0); /* Fallback color */
   background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
   background-color: #fefefe;
   margin: 15% auto; /* 15% from the top and centered */
   padding: 20px;
   border: 1px solid #888;
   width: 30%; /* Could be more or less, depending on screen size */
}
</style>