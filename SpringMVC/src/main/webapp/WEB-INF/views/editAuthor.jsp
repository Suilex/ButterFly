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
  <div align="center"><h2>Edit the author in the form below</h2>
    <br>
    <br>
    <br>


    <form style="width:300px" method = "POST">
      <div class="form-group">
        Id <input  class="form-control" readonly name = "Id"  value= ${author.getId()}>
      </div>
      <div class="form-group">
        FirstName <input  class="form-control" name = "FirstName" value= ${author.getFirstName()}>
      </div>
      <div class="form-group">
        LastName <input  class="form-control" name = "LastName" value= ${author.getLastName()}>
      </div>
      <div class="form-group">
        Year <input class="form-control" name = "Year" value= ${author.getYear()}>
      </div>
      <div class="form-group">
        Already added <select class="form-control">
        <#list bookList as book>
          <option>${book.getName()}</option>
          </#list>
        </select>
    </div>
    <div class="form-group">
          Add <select class="form-control" name = "bookId">
          <option value = "0">No add</option>
          <#list books as item>
            <option value = ${item.getId()}>${item.getName()}</option>
            </#list>
          </select>
      </div>
      <br>
      <button style="width:300px" class="btn btn-success">Submit</button>
    </form>
    <br>
    <a href="/author"><button style="width:300px" class="btn btn-primary">&nbsp Back &nbsp</button></a>

  </div>
<br><br>
</body>
</html>