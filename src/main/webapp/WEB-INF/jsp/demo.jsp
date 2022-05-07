<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table>

    <% for(int i=1;i<=9;i++){ %>
        <tr>

                <% for(int j=1;j<=9;j++){ %>
                <td>

                    <p> <%=String.format("%d * %d = %d", i,j,i*j) %> </p>


                </td>
                <% }%>


        </tr>
    <% }%>

</table>


<style>
    table, tr, td {
        border: 1px solid;
        padding: 3px;
    }
    table{
        border-collapse: collapse;
    }

</style>

</body>
</html>
