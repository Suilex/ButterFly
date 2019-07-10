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


    <br>
    <br>
    <br>
    <div align="center"><h2>Add the book in the form below</h2>
        <br>
        <br>
        <br>
        <form style="width:300px" method="POST">
          <div class="form-group">
            <input  class="form-control" name = "Name" placeholder="Name">
        </div>
        <div class="form-group">
            <input  class="form-control" name = "Description" placeholder="Description">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name = "Published" placeholder="Published">
        </div>
        <div class="form-group">
            <input type="number" class="form-control" name = "Year" placeholder="Year">
        </div>
        <div class="form-group">
            <select class="form-control"  name = "authorId">
            <#list authorList as author>
              <option value = ${author.getId()}>${author.getFirstName()}</option>
              </#list>
            </select>
        </div>
        <br>
        <button style="width:300px" class="btn btn-success">Submit</button>
    </form>
    <br>
    <a href="/book"><button style="width:300px" class="btn btn-primary">&nbsp Back &nbsp</button></a>
</div>


</body>
</html>