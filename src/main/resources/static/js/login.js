/**
 * 登录
 */
 $(function(){
     layui.use(['form' ,'layer'], function() {
         var form = layui.form;
         var layer = layui.layer;
         form.on("submit(login)",function () {
             login();
             return false;
         });
         var path=window.location.href;
    	 console.info("==请求的uri:"+path);
         if(path.indexOf("kickout")>0){
             layer.alert("您的账号已在别处登录；若不是您本人操作，请立即修改密码！",function(){
                 window.location.href="/login";
             });
         }
     })
 })

function login(){
    var flag=checkParams();
    console.info("==flag:"+flag);
    if(flag!=false){
        $.post("/user/login",$("#useLogin").serialize(),function(data){
            console.log("data:"+data)
            if(data.code=="1000"){
                layer.alert("登录成功",function () {
                    window.location.href="/home";
                });
            }else{
                layer.alert(data.message,function(){
                    layer.closeAll();//关闭所有弹框
                });
            }
        });
    }
}

function checkParams(){
	console.info("111111111111111111111111111111");
    //  校验
    var username=$("#username").val();
    var password=$("#password").val();
    if("ok"!=ValidateUtils.checkUserName(username) || "ok"!=ValidateUtils.checkSimplePassword(password)){
        layer.alert("请您输入正确的用户名和密码");
        return false;
    }
}