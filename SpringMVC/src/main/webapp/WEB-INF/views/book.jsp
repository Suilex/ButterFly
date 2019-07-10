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
    <a href="/"> <button class="btn btn-primary">Back</button> </a>
    <br>
    <br>
     <a href = "/addbook"> <button type="button" class="btn btn-success"> Add </button> </a>
    <br>
    <br>
    <div class="container">
        <h2>Full list of book:</h2>
        <br>

        <table border ='1' class="table table-hover">
            <tbody>
                <tr>
                    <th> Id </th>
                    <th> Name </th>
                    <th> Description </th>
                    <th> Published </th>
                    <th> Year </th>
                </tr>
                <#list books as book>
                <tr>
                    <td> ${book.getId()} </td>
                    <td> <a href= "/pageBook/${book.getId()}"> ${book.getName()} </a> </td>
                    <td> ${book.getDescription()} </td>
                    <td> ${book.getPublished()} </td>
                    <td> ${book.getYear()} </td>
                    <td> <a href="/book/${book.getId()}"><button class="btn btn-danger">Delete</button></a></td>
                    <td> <a href="/editBook/${book.getId()}"><button class="btn btn-info">Edit</button></a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>
</html>