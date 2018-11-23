/**
 * 用户管理
 */
var pageCurr;
$(function() {
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        tableIns=table.render({
            elem: '#examList'
            ,url:'/exam/getExams'
            ,method: 'post' //默认：get请求
            ,cellMinWidth: 80
            ,page: true,
            request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            },response:{
                statusName: 'code' //数据状态的字段名称，默认：code
                ,statusCode: 200 //成功的状态码，默认：0
                ,countName: 'totals' //数据总数的字段名称，默认：count
                ,dataName: 'list' //数据列表的字段名称，默认：data
            }
            ,cols: [[
                {type:'numbers'}
                ,{field:'examNo', title:'试题编号',width:80, unresize: true, sort: true}
                ,{field:'examName', title:'试题名称'}
                ,{field:'createTime', title:'新增时间'}
                ,{field:'examSource', title: '试题来源'}
                ,{fixed:'right', title:'操作',width:140,align:'center', toolbar:'#optBar'}
            ]]
            ,  done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                //console.log(curr);
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });

        //监听工具条
        table.on('tool(examTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
//                delUser(data,data.id,data.username);
            } else if(obj.event === 'edit'){
                //编辑
//                getUserAndRoles(data,data.id);
            }
        });
        //监听提交
        form.on('submit(examSubmit)', function(data){
            // TODO 校验
            formSubmit(data);
            return false;
        });

    });
    //搜索框
    layui.use(['form','laydate'], function(){
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#insertTimeStart'
        });
        laydate.render({
            elem: '#insertTimeEnd'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            load(data);
            return false;
        });
    });
});
//提交表单
function formSubmit(obj){
    var currentExam=$("#currentExam").html();
    submitAjax(obj,currentExam);
}
function submitAjax(obj,currentExam){
//    $.ajax({
//        type: "POST",
//        data: $("#examForm").serialize(),
//        url: "/user/setUser",
//        success: function (data) {
//            if(isLogin(data)){
//                if (data == "ok") {
//                    layer.alert("操作成功",function(){
//                        if($("#id").val()==currentUser){
//                            //如果是自己，直接重新登录
//                            parent.location.reload();
//                        }else{
//                            layer.closeAll();
//                            cleanUser();
//                            //$("#id").val("");
//                            //加载页面
//                            load(obj);
//                        }
//                    });
//                } else {
//                    layer.alert(data,function(){
//                        layer.closeAll();
//                        //加载load方法
//                        load(obj);//自定义
//                    });
//                }
//            }
//        },
//        error: function () {
//            layer.alert("操作请求错误，请您稍后再试",function(){
//                layer.closeAll();
//                //加载load方法
//                load(obj);//自定义
//            });
//        }
//    });
}
//开通用户
function addExam(){
//    $.get("/auth/getRoles",function(data){
//        if(isLogin(data)){
//            if(data!=null){
//                //显示角色数据
//                $("#roleDiv").empty();
//                $.each(data, function (index, item) {
//                    // <input type="checkbox" name="roleId" title="发呆" lay-skin="primary"/>
//                    var roleInput=$("<input type='checkbox' name='roleId' value="+item.id+" title="+item.roleName+" lay-skin='primary'/>");
//                    //未选中
//                    /*<div class="layui-unselect layui-form-checkbox" lay-skin="primary">
//                        <span>发呆</span><i class="layui-icon">&#xe626;</i>
//                        </div>*/
//                    //选中
//                    // <div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary">
//                    // <span>写作</span><i class="layui-icon">&#xe627;</i></div>
//                    var div=$("<div class='layui-unselect layui-form-checkbox' lay-skin='primary'>" +
//                        "<span>"+item.roleName+"</span><i class='layui-icon'>&#xe626;</i>" +
//                        "</div>");
//                    $("#roleDiv").append(roleInput).append(div);
//                })
//                openUser(null,"开通用户");
//                //重新渲染下form表单 否则复选框无效
//                layui.form.render('checkbox');
//            }else{
//                //弹出错误提示
//                layer.alert("获取角色数据有误，请您稍后再试",function () {
//                    layer.closeAll();
//                });
//            }
//        }
//    });
}
//function getUserAndRoles(obj,id) {
//    //如果已经离职，提醒不可编辑和删除
//    if(obj.job){
//        layer.alert("该用户已经离职，不可进行编辑；</br>  如需编辑，请设置为<font style='font-weight:bold;' color='green'>在职</font>状态。");
//    }else if(obj.del){
//        layer.alert("该用户已经删除，不可进行编辑；</br>  如需编辑，请先<font style='font-weight:bold;' color='blue'>恢复</font>用户状态。");
//    }else{
//        //回显数据
//        $.get("/user/getUserAndRoles",{"id":id},function(data){
//                if(data.msg=="ok" && data.user!=null){
//                    $("#examNo").val(data.user.examNo==null?'':data.user.examNo);
//                    $("#version").val(data.user.version==null?'':data.user.version);
//                    $("#username").val(data.user.username==null?'':data.user.username);
//                    $("#mobile").val(data.user.mobile==null?'':data.user.mobile);
//                    $("#email").val(data.user.email==null?'':data.user.email);
//                    //显示角色数据
//                    $("#roleDiv").empty();
//                    $.each(data.roles, function (index, item) {
//                        var roleInput=$("<input type='checkbox' name='roleId' value="+item.id+" title="+item.roleName+" lay-skin='primary'/>");
//                        var div=$("<div class='layui-unselect layui-form-checkbox' lay-skin='primary'>" +
//                            "<span>"+item.roleName+"</span><i class='layui-icon'>&#xe626;</i>" +
//                            "</div>");
//                        if(existRole!='' && existRole.indexOf(item.id)>=0){
//                             roleInput=$("<input type='checkbox' name='roleId' value="+item.id+" title="+item.roleName+" lay-skin='primary' checked='checked'/>");
//                             div=$("<div class='layui-unselect layui-form-checkbox  layui-form-checked' lay-skin='primary'>" +
//                                "<span>"+item.roleName+"</span><i class='layui-icon'>&#xe627;</i>" +
//                                "</div>");
//                        }
//                        $("#roleDiv").append(roleInput).append(div);
//                    });
//                    openUser(id,"设置用户");
//                    //重新渲染下form表单中的复选框 否则复选框选中效果无效
//                    // layui.form.render();
//                    layui.form.render('checkbox');
//                }else{
//                    //弹出错误提示
//                    layer.alert(data.msg,function () {
//                        layer.closeAll();
//                    });
//                }
//        });
//    }
//}

function load(obj){
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function cleanExam(){
    //$("#id").val("");
}