<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gio hang</title>
    <link rel="stylesheet" href="/css/giohang.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- <link rel="stylesheet" href="./coban.css"> -->
</head>

<body>
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
<div class="noi-dung">
    <div class="ds-san-pham">
        <div class="td-bang-sp-head td-bang-sp">
            <div id="td-san-pham">Sản phẩm</div>
            <div>Đơn giá</div>
            <div>Số lượng</div>
            <div>Số tiền</div>
            <div>Thao tác</div>
        </div>
        <div class="td-bang-sp sanpham">
            <div id="td-san-pham">
                <img class="sp-anh"
                     src="https://pickbazar-react-rest.vercel.app/_next/image?url=https%3A%2F%2Fpickbazarlaravel.s3.ap-southeast-1.amazonaws.com%2F7%2FCorn.jpg&w=1920&q=75"
                     alt="">
                <h3 class="ten-sp">Ngô</h3>
            </div>
            <div class="gia">10.100</div>
            <div>
                <button onclick="giamSL(1)"> - </button>
                <input value="1" id="1" class="sp-so-luong-inp soluong" type="number">
                <button onclick="tangSL(1)"> + </button>
            </div>
            <div class="tong">10.100</div>
            <div>Xóa</div>
        </div>
        <div class="td-bang-sp sanpham">
            <div id="td-san-pham">
                <img class="sp-anh" src="https://www.kidsplaza.vn/blog/wp-content/uploads/2020/12/suachua_itvg-1024x768.jpg"
                     alt="">
                <h3 class="ten-sp">Sữa</h3>
            </div>
            <div class="gia">10.100</div>
            <div>
                <button onclick="giamSL(2)"> - </button>
                <input value="1" id="2" class="sp-so-luong-inp soluong" type="number">
                <button onclick="tangSL(2)"> + </button>
            </div>
            <div class="tong">10.100</div>
            <div>Xóa</div>
        </div>

        <div class="sp-tinh">
            <div>
                <div>Tổng tiền: <span id="tong-tien">10.100</span></div>
            </div>
            <button class="button-13">
                Thanh toán
            </button>
        </div>


    </div>
</div>
</body>


<script src="/js/giohang.js"></script>

</html>