<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/9
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>区域管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
   <script src="js/district.js"></script>

</head>
<body>


<!--显示所有区域-->
<table id="dg" style="width: 800px"></table>

<%--制作工具栏--%>
    <div id="ToolBar">
        <div style="height: 40px;">
            <a href="javascript:addDialog()" class="easyui-linkbutton"
               iconCls="icon-add" plain="true">添加</a> <a
                href="javascript:updateDialog()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:delMoreDistrict()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">多项删除</a>
        </div>
    </div>

<%--添加对话框--%>
        <div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
             style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
            <form method="post" action="addDistrict" name="form1" id="form1">
                区域名称:<input type="text" name="name">
            </form>
        </div>
<%--添加对话框的按钮--%>
        <div id="AddDialogButtons">
            <a href="javascript:SaveDistrict()" class="easyui-linkbutton"
               iconCls="icon-ok">保存</a>
            <a href="javascript:CloseAddDialog('AddDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
        </div>

<!--修改对话框-->
<div id="updateDialog" class="easyui-dialog" buttons="#updateDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form method="post" action="updateDistrict" id="form2" name="form1">
        <input type="hidden" name="id" id="name">
        区域名称:<input type="text" name="name" id="name3">
    </form>
</div>

<!--添加对话框的按钮-->
<div id="updateDialogButtons">
    <a href="javascript:UpdateDistrict()" class="easyui-linkbutton"
       iconCls="icon-ok">更新</a>
    <a href="javascript:CloseAddDialog('updateDialog')"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>


<!--显示街道对话框-->
<div id="showStreetDialog" class="easyui-dialog" buttons="#updateDialogButtons"
     style="width: 500px; height: 350px; padding: 10px 20px;" closed="true">

    <table id="dgStreet"></table><hr>
    <!%--添加街道对话框--%>
    <div id="AddStreet">
        <form method="post" action="addDistrict" onsubmit="return judge()" id="form3" name="form3">
            <input type="hidden" name="districtId" id="sId">
            <input type="hidden" name="id" id="id">
            街道名称:<input type="text" name="name" id="sname1">
            <input type="submit" value="添加" >
        </form>

    </div>

</div>
<!--添加修改对话框的按钮-->
<div id="updateDialogButtons">
    <a href="javascript:UpdateStreet()" class="easyui-linkbutton"
       iconCls="icon-ok">更新</a>
    <a href="javascript:CloseAddDialog('updateDialog')"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
