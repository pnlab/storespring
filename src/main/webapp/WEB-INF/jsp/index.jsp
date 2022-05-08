<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Store</title>
    <%-- <link rel="stylesheet" href="/css/style.css">--%>
    <%-- <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet'
        type='text/css'>--%>
    <%-- <link rel="stylesheet" href="/css/giohang.css">--%>
    <%-- <link rel="stylesheet" href="/css/sp.css">--%>

<body>

<div class="flex flex-col min-h-screen transition-colors duration-150 bg-gray-100">
    <%-- <%@include file="./layout/header.jsp" %>--%>
    <%@include file="./layout/head.jsp" %>
    <div class="min-h-screen mt-22">
        <div class="flex flex-1 border-t border-solid border-border-200 border-opacity-70">
            <%@include file="./layout/sidebar.jsp" %>
            <div class="grid grid-flow-row-dense md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 mx-auto ">
                <c:forEach begin="0" end="${fn:length(products) - 1}" var="index">
                    <div class="relative flex flex-col m-5 bg-white z-30 p-10 rounded-md shadow-md	">
                        <p class="absolute top-2 right-2 text-xs italic text-gray-400 ">
                            Thưc pham
                        </p>
                        <img style="width: 200px; height: 200px" class="object-cover"
                             src="${products[index].getImage()}"
                             height="200" width="200"/>
                        <div class="flex flex-1"></div>
                        <h4 class="my-3">${products[index].getName()}</h4>

                        <p class="text-xs my-2 line-clamp-2 ">${products[index].getDescription()}</p>
                        <div class="mb-5">
                            <p>${products[index].getPrice()}</p>
                        </div>
                        <button class="mt-auto button border border-gray-200 px-5 py-3 rounded-md hover:bg-[#009f7f] hover:text-white">
                            Thêm vào giỏ hàng
                        </button>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- partial -->
<%--<script src="/js/script.js">
    </script>--%>
<%--<script src="./SanPham.js">
    </script>--%>
<script src="https://cdn.tailwindcss.com"></script>
<script>
    tailwind.config = {
        theme: {
            extend: {
                colors: {
                    clifford: '#da373d',
                }
            }
        }
    }
</script>

</body>

</html>