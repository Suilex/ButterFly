<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title></title>
</head>
<body>

   <a href="/book"> <button class="btn btn-primary">Back</button> </a>
   <br>
   <br>

   <div class="container">
    <h1> Book Name:
                ${Name.getName()} </h1>
        <br>
        <table border ='1' class="table table-hover">
            <tbody>
                <tr>
                    <th> Id </th>
                    <th> FirstName </th>
                    <th> LastName </th>
                    <th> Year </th>
                </tr>
                 <#list authors as author>
                <tr>
                    <td> ${author.getId()} </td>
                    <td> <a href= "/pageAuthor/${author.getId()}"> ${author.getFirstName()} </a> </td>
                    <td> ${author.getLastName()} </td>
                    <td> ${author.getYear()} </td>
                </tr>
                </#list>
        </tbody>
    </table>

</div>
</body>
</html>