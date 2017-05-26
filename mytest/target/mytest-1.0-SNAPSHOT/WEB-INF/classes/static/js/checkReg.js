$(function(){
    var checkRegData = {
        bool:true,

    };

       function checkUsername(code){
           var bool = true;
           var re =/^[a-zA-z]\w{3,15}$/;
           var username = $("input[name='username']").val().trim();
           if(code==0 && username.length==0){
               $("#usernameError").html("");
               return false;
           }
           if(re.test(username)){
               $("#usernameError").html("");
               $.ajax({
                   type: "POST",
                   url: "/checkUserName",
                   async: false,
                   data: {"username":username},
                   success: function(data){
                       if(data.issuccess){
                           bool = true;
                       }else{
                           $("#usernameError").html(data.msg);
                           bool = false;
                       }
                   }
               });
           }else{
               $("#usernameError").html("用户名有误");
               bool = false;
           }
           return bool;
       }

       function checkPWd(code) {
           var re =/^1\d{6,10}$/;
           var pwd = $("input[name='pwd']").val().trim();
           if(code ==0 && pwd.length==0){
               $("#pwdError").html("");
               return false;
           }
           if(!re.test(pwd)){
               $("#pwdError").html("密码有误");
               return false;
           }else{
               $("#pwdError").html("");
               return true;
           }
       }

       function checkMobile(code) {
           var bool = true;
           var re =/^1\d{10}$/;
           var mobile = $("input[name='mobile']").val().trim();
           if(code==0 && mobile.length==0){
               $("#mobileError").html("");
               return false;
           }
           if(re.test(mobile)){
               $("#mobileError").html("");
               $.ajax({
                   type: "POST",
                   url: "/checkMobile",
                   async: false,
                   data: {"mobile":mobile},
                   success: function(data){
                       if(data.issuccess){
                           bool =  true;
                       }else{
                           $("#mobileError").html(data.msg);
                           bool =  false;
                       }
                   }
               });
           }else{
               $("#mobileError").html("电话有误");
               bool =  false;
           }
           return bool;
       }
       $("input[name='username']").focusout(function(){
           checkUsername(0);
       });
       $("input[name='pwd']").focusout(function(){
           checkPWd(0);
       });

       $("input[name='mobile']").focusout(function(){
           checkMobile(0);
       });

       $("form").submit(function () {
           if(checkUsername(1) && checkPWd(1) && checkMobile(1)){
               return true;
           }
           return false;
       });
});