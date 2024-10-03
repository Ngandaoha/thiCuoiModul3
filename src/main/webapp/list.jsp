<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin mặt bằng </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-3">
    <form id="filterForm" method="get" action="">
        <div class="row">
            <div class="col-md-6">
                <label for="loaiMatBang" class="form-label">Loại mặt bằng</label>
                <select id="loaiMatBang" name="loaiMatBang" class="form-select">
                    <option value="">Tất cả</option>
                    <option value="1">Văn phòng chia sẻ</option>
                    <option value="2">Văn phòng chọn gói</option>
                </select>
            </div>
            <div class="col-md-6">
                <label for="tang" class="form-label">Tầng</label>
                <select id="tang" name="tang" class="form-select">
                    <option value="">Tất cả</option>
                    <c:forEach begin="1" end="15" varStatus="status">
                        <option value="${status.index}">${status.index}</option>
                    </c:forEach>
                </select>
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-md-12 text-center">
                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            </div>
        </div>
    </form>
</div>
<div>
    <table id="mainTable" class="table table-bordered table-striped text-center align-middle mx-auto" style="width:100%">
        <thead>
        <tr>
            <th>Mã MB</th>
            <th>Diện tích</th>
            <th>Trạng thái</th>
            <th>Tầng</th>
            <th>Loại văn phòng</th>
            <th>Giá cho thuê</th>
            <th>Ngày bắt đầu</th>
            <th>Ngày kết thúc</th>
            <th>Tùy chọn</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var="tmp" items="${list}" >
            <tr>
                <td><c:out value="${tmp.maMB}"/></td>
                <td><c:out value="${tmp.dienTich}"/></td>
                <td><c:out value="${tmp.trangThai.tenTT}"/></td>
                <td><c:out value="${tmp.tang}"/></td>
                <td><c:out value="${tmp.loai.tenLoai}"/></td>
                <td><c:out value="${tmp.gia}"/></td>
                <td><c:out value="${tmp.ngayBatDau}"/></td>
                <td><c:out value="${tmp.ngayKetThuc}"/></td>
                <td>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal" data-id="${matbang.maMB}">Xóa</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
