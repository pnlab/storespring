<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gio hang</title>
    <link rel="stylesheet" href="./css/giohang.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./js/giohang.js"></script>
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
</head>

<body>

<jsp:include page="./layout/header.jsp"/>


<%--<div class="noi-dung">--%>

<%--&lt;%&ndash;<h1>${greeting}</h1>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>${products[0]}</h2>&ndash;%&gt;--%>
<%--    <h1 class="text-3xl font-bold underline text-clifford">--%>
<%--        Hello world!--%>
<%--    </h1>--%>
<%--<tr>--%>
<%--    <td><c:out value="${products[index].getName()}"/></td>--%>
<%--    <td><c:out value="${products[index].getPrice()}"/></td>--%>
<%--</tr>--%>


<%--</div>--%>

<div class="min-h-screen">
    <div class="flex border-t border-solid border-border-200 border-opacity-70">
        <div class="w-full px-4 pb-8 lg:p-8">
            <div class="grid grid-cols-[repeat(auto-fill,minmax(250px,1fr))] gap-3">
                <c:forEach begin="0" end="${fn:length(products) - 1}" var="index">

                    <article
                            class="product-card cart-type-neon border border-border-200 rounded h-full bg-light overflow-hidden shadow-sm transition-all duration-200 hover:shadow transform hover:-translate-y-0.5">
                        <div class="relative flex items-center justify-center cursor-pointer w-auto h-48 sm:h-64"><span
                                class="sr-only">Product Image</span><span
                                style="box-sizing:border-box;display:block;overflow:hidden;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;position:absolute;top:0;left:0;bottom:0;right:0">
                                <img
                                        alt="Apples"
                                        src="./img/default.jpg"
                                        decoding="async" data-nimg="fill" class="product-image"
                                        style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:contain"
                                        sizes="100vw"/>
                        </div>
                        <header class="p-3 md:p-6">
                            <div class="flex items-center mb-2"><span
                                    class="text-sm md:text-base text-heading font-semibold">${products[index].getPrice()}</span>
                                    <%--                                <del class="text-xs md:text-sm text-muted ltr:ml-2 rtl:mr-2">$2.00</del>--%>
                            </div>
                            <h3 class="text-xs md:text-sm text-body truncate mb-4 cursor-pointer">${products[index].getName()}</h3>
                            <button class="flex items-center justify-between w-full text-xs transition-colors bg-gray-100 rounded group h-7 md:h-9 md:text-sm text-body-dark hover:bg-accent hover:border-accent hover:text-light focus:outline-none focus:bg-accent focus:border-accent focus:text-light">
                                <span class="flex-1">Add</span><span
                                    class="grid transition-colors duration-200 bg-gray-200 w-7 h-7 md:w-9 md:h-9 place-items-center ltr:rounded-tr rtl:rounded-tl ltr:rounded-br rtl:rounded-bl group-hover:bg-accent-600 group-focus:bg-accent-600"><svg
                                    fill="none" viewBox="0 0 24 24" stroke="currentColor" class="w-4 h-4 stroke-2"><path
                                    stroke-linecap="round" stroke-linejoin="round"
                                    d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path></svg></span></button>
                        </header>
                    </article>

                </c:forEach>

            </div>


        </div>
    </div>

</div>


</body>


<script>
    fetch("/product/").then(res => res.json()).then(res => {
        console.log("product", res)
    })
</script>


</html>