<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="dieuhuong">
    <!-- logo -->
    <div class="dieuhuong-trai">
        <a href="index.html">
            <img id="logo-image" src="https://www.logolynx.com/images/logolynx/b2/b23666d57f4e17102209423105dfc442.png"
                 alt="">
        </a>
        <div class="danhmuc">
            <button class="danhmuc-nut" onclick="hienThiDanhMuc()">Danh mục

            </button>
            <div class="danhmuc-noidung" id="danhmuc-nd">
                <a href="#">Nước uống</a>
                <a href="#">Rau củ</a>
                <a href="#">Thịt và cá</a>
                <a href="#">Trứng và sữa</a>
                <a href="#">Bánh</a>
                <a href="#">Gia vị</a>
                <c:forEach begin="0" end="${fn:length(categories) - 1}" var="index">
                    <a href="#">${categories[index].getName()}</a>
                </c:forEach>
            </div>
        </div>

    </div>
    <!-- Tim kiem -->
    <div id="timkiem">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Search_Icon.svg/1024px-Search_Icon.svg.png"
             alt="">

        <input type="text">

    </div>
    <!-- Dang nhap -->
    <div class="dieuhuong-phai">

        <div class="giohang-icon">
            <img class="dieuhuong-icon"
                 src="https://thumbs.dreamstime.com/b/shopping-cart-icon-trolley-icon-shopping-cart-icon-trolley-icon-vector-illustration-isolated-white-background-163727286.jpg"
                 alt="">

            <div class='giohang-soluong'>5</div>
        </div>
        <div>
            <img class="dieuhuong-icon" src="https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png"
                 alt="">
        </div>

    </div>
</header>