<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="sm">
    <form method="POST" enctype="multipart/form-data" action="/upload/uploadBlog">
        <p>文件：<input type="file" name="file"/></p>
        <p><input type="submit" value="上传" /></p>
    </form>
</div>


